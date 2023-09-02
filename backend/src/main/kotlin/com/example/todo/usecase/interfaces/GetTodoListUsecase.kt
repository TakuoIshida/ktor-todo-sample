package com.example.todo.usecase.interfaces

import com.example.todo.domain.entity.TodoEntity
import java.util.UUID

interface GetTodoListUsecase {

    fun execute(): List<TodoEntity>
}