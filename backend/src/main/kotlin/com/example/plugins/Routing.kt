package com.example.plugins

import com.example.todo.controller.todo
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        healthCheck()
        todo()
        get("/") {
            println(System.getenv("DB_USER")?: "Not Found")
            call.respondText("Hello World!")
        }
    }
}

fun Route.healthCheck() {
    get("/_status") {
        call.response.status(HttpStatusCode.OK)
    }
}
