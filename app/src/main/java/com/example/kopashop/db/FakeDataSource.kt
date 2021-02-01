package com.example.kopashop.db

interface FakeDataSource {
    suspend fun getUsername(name: String)
    suspend fun getSurname(surname: String)
    suspend fun getTown(town: String)
    suspend fun getNumber(number: String)
}