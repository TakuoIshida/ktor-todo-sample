package com.example.todo.usecase.interfaces

import com.example.todo.domain.entity.TodoEntity
import java.util.UUID

interface UpdateTodoUsecase {

    fun execute(input: Input)

    data class Input (
        val id: UUID,
        val title: String,
        val content: String,
        val fileName: String?
    )
}
