package com.example.todo.usecase.interactor

import com.example.todo.domain.entity.TodoEntity
import com.example.todo.infrastructure.database.repository.TodoRepositoryImpl
import com.example.todo.usecase.interfaces.CreateTodoUsecase
import com.example.todo.usecase.interfaces.GetTodoDetailUsecase
import com.example.todo.usecase.interfaces.GetTodoListUsecase

class GetTodoListInteractor: GetTodoListUsecase {
    override fun execute(): List<TodoEntity> {
        return TodoRepositoryImpl().find()
    }
}