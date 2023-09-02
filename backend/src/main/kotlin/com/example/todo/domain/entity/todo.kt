package com.example.todo.domain.entity

import java.util.UUID

data class TodoEntity private constructor(
    val id: UUID,
    val title: String,
    val content: String,
    val fileName: String?,
) {
    companion object {
        fun new(
            title: String,
            content: String,
            fileName: String?
        ): TodoEntity {
            return TodoEntity(
                id = UUID.randomUUID(),
                title,
                content,
                fileName
            )
        }

        fun update(
            id: UUID,
            title: String,
            content: String,
            fileName: String?
        ): TodoEntity {
            return TodoEntity(
                id = UUID.randomUUID(),
                title,
                content,
                fileName
            )
        }

        fun restore(
            id: UUID,
            title: String,
            content: String,
            fileName: String?
        ): TodoEntity {
            return TodoEntity(
                id,
                title,
                content,
                fileName
            )
        }
    }


}
