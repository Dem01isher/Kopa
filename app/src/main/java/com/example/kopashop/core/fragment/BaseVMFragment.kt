package com.example.kopashop.core.fragment

import androidx.databinding.ViewDataBinding
import com.example.kopashop.core.view_model.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel
import kotlin.reflect.KClass

abstract class BaseVMFragment<VM: BaseViewModel, B: ViewDataBinding> : BaseBindingFragment<B>() {

    protected abstract val viewModelClass: KClass<VM>

    protected val viewModel: VM = initViewModel()

    private fun initViewModel(): VM {
        return getViewModel(clazz = viewModelClass)
    }
}