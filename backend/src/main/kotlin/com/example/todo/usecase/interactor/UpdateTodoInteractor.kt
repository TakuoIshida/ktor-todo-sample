package com.example.todo.usecase.interactor

import com.example.todo.domain.entity.TodoEntity
import com.example.todo.infrastructure.database.repository.TodoRepositoryImpl
import com.example.todo.usecase.interfaces.CreateTodoUsecase
import com.example.todo.usecase.interfaces.GetTodoDetailUsecase
import com.example.todo.usecase.interfaces.GetTodoListUsecase
import com.example.todo.usecase.interfaces.UpdateTodoUsecase

class UpdateTodoInteractor : UpdateTodoUsecase {
    override fun execute(input: UpdateTodoUsecase.Input) {
        return TodoRepositoryImpl().update(
            TodoEntity.update(
                id = input.id, title = input.title, content = input.content, fileName = input.fileName
            )
        )
    }
}
