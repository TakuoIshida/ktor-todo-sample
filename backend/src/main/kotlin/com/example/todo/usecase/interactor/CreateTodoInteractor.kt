package com.example.todo.usecase.interactor

import com.example.todo.domain.entity.TodoEntity
import com.example.todo.infrastructure.database.repository.TodoRepositoryImpl
import com.example.todo.usecase.interfaces.CreateTodoUsecase

class CreateTodoInteractor: CreateTodoUsecase {
    override fun execute(input: CreateTodoUsecase.Input) {
        val newEntity = TodoEntity.new(
            title = input.title,
            content = input.content,
            fileName = input.fileName
        )

        TodoRepositoryImpl().create(newEntity)
    }
}