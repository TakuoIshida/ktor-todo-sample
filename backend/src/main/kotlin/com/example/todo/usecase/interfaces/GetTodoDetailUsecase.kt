package com.example.todo.usecase.interfaces

import com.example.todo.domain.entity.TodoEntity
import java.util.UUID

interface GetTodoDetailUsecase {

    fun execute(input: Input): TodoEntity?

    data class Input (
        val id: UUID,
    )
}