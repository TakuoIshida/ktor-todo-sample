package com.example.todo.controller

import com.example.todo.domain.entity.TodoEntity
import com.example.todo.usecase.interactor.*
import com.example.todo.usecase.interfaces.CreateTodoUsecase
import com.example.todo.usecase.interfaces.DeleteTodoUsecase
import com.example.todo.usecase.interfaces.GetTodoDetailUsecase
import com.example.todo.usecase.interfaces.UpdateTodoUsecase
import com.example.utils.UUIDAsString
import com.fasterxml.jackson.databind.ser.std.UUIDSerializer
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.util.UUID


@Serializable
data class DetailResponse(val id: UUIDAsString, val title: String, val content: String, val fileName: String?)

@Serializable
data class ListItem(val id: UUIDAsString, val title: String, val content: String, val fileName: String?)

@Serializable
data class ListResponse(val todos: List<ListItem>)


@Serializable
data class CreateRequest(
    val title: String, val content: String, val fileName: String?
)

@Serializable
data class UpdateRequest(val title: String, val content: String, val fileName: String?)

fun Route.todo() {
    get("/api/todo/{id}") {
        val id = UUID.fromString(call.parameters["id"]) ?: throw IllegalArgumentException("Invalid ID")
        val detail: TodoEntity? = GetTodoDetailInteractor().execute(GetTodoDetailUsecase.Input(id))
        if (detail == null) {
            call.respond(HttpStatusCode.NotFound)
            return@get
        }
        call.respond(
            HttpStatusCode.OK, DetailResponse(
                id = detail.id, title = detail.title, content = detail.content, fileName = detail.fileName
            )
        )
    }

    get("/api/todo") {
        val list = GetTodoListInteractor().execute()
        call.respond(HttpStatusCode.OK, ListResponse(list.map { item ->
            ListItem(id = item.id, title = item.title, content = item.content, fileName = item.fileName)
        }))
    }

    put("/api/todo/{id}") {
        val id = UUID.fromString(call.parameters["id"]) ?: throw IllegalArgumentException("Invalid ID")
        val body = call.receive<UpdateRequest>()
        UpdateTodoInteractor().execute(
            UpdateTodoUsecase.Input(
                id = id,
                title = body.title,
                content = body.content,
                fileName = body.fileName
            )
        )
        call.respond(HttpStatusCode.NoContent)
    }

    post("/api/todo") {
        val body = call.receive<CreateRequest>()
        CreateTodoInteractor().execute(
            CreateTodoUsecase.Input(
                title = body.title,
                content = body.content,
                fileName = body.fileName
            )
        )
        call.respond(HttpStatusCode.Created)
    }

    delete("/api/todo/{id}") {
        val id = UUID.fromString(call.parameters["id"]) ?: throw IllegalArgumentException("Invalid ID")
        DeleteTodoInteractor().execute(DeleteTodoUsecase.Input(id))
        call.respond(HttpStatusCode.NoContent)
    }
}
