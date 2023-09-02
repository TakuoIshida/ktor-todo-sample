package com.example.todo.usecase.interfaces

interface CreateTodoUsecase {

    fun execute(input: CreateTodoUsecase.Input): Unit
    data class Input (
        val title: String,
        val content: String,
        val fileName: String?
    )
}