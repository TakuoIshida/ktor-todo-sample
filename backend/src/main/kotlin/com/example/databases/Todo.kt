package com.example.databases

import org.jetbrains.exposed.dao.id.UUIDTable

class Todo: UUIDTable() {
    val title   = varchar("title", 256).uniqueIndex()
    val content = varchar("content", 512)
    val fileName = varchar("fileName", 512).nullable()
}
