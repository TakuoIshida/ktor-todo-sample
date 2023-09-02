package com.example.todo.usecase.interactor

import com.example.todo.domain.entity.TodoEntity
import com.example.todo.infrastructure.database.repository.TodoRepositoryImpl
import com.example.todo.usecase.interfaces.CreateTodoUsecase
import com.example.todo.usecase.interfaces.GetTodoDetailUsecase

class GetTodoDetailInteractor: GetTodoDetailUsecase {
    override fun execute(input: GetTodoDetailUsecase.Input): TodoEntity? {
        return TodoRepositoryImpl().findById(input.id)
    }
}