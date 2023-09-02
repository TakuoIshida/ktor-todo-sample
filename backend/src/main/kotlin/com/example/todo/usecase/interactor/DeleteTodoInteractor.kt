package com.example.todo.usecase.interactor

import com.example.todo.domain.entity.TodoEntity
import com.example.todo.infrastructure.database.repository.TodoRepositoryImpl
import com.example.todo.usecase.interfaces.*

class DeleteTodoInteractor : DeleteTodoUsecase {
    override fun execute(input: DeleteTodoUsecase.Input) {
        return TodoRepositoryImpl().delete(
            id = input.id
        )
    }
}
