package com.example.todo.usecase.interfaces

import com.example.todo.domain.entity.TodoEntity
import java.util.UUID

interface DeleteTodoUsecase {

    fun execute(input: Input)

    data class Input (
        val id: UUID,
    )
}
