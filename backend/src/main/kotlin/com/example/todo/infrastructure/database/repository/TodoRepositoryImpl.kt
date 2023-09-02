package com.example.todo.infrastructure.database.repository

import com.example.todo.domain.entity.TodoEntity
import java.util.UUID

class TodoRepositoryImpl {

    fun find(): List<TodoEntity> {
        return listOf(TodoEntity.restore(
            id = UUID.randomUUID(),
            title = "list title",
            content = "context",
            fileName = "fileName"
        ), TodoEntity.restore(
            id = UUID.randomUUID(),
            title = "list title2",
            content = "context",
            fileName = "fileName"
        ))
    }
    fun findById(id: UUID): TodoEntity? {
        println("id $id")
        return TodoEntity.restore(
            id = UUID.randomUUID(),
            title = "read title",
            content = "context",
            fileName = "fileName"
        )
    }

    fun create(todoEntity: TodoEntity) {
        println("$todoEntity, created!")
        return
    }

    fun update(todoEntity: TodoEntity) {
        println("$todoEntity, update!")
        return
    }

    fun delete(id: UUID) {
        println("$id, delete!")
        return
    }
}
