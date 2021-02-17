 package com.example.kopashop.di

import com.example.kopashop.model.BootsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { BootsViewModel() }
}