package com.example.kopashop.di

import com.example.kopashop.data.repositories.BootsRepositoryImpl
import com.example.kopashop.domain.repositories.BootsRepository
import org.koin.dsl.module

val repositoriesModule = module {
    single<BootsRepository> { BootsRepositoryImpl(get()) }
}