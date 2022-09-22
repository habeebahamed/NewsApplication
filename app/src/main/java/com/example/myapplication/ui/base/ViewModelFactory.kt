package com.example.myapplication.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.repository.AuthRepository
import com.example.myapplication.data.repository.BaseRepository
import com.example.myapplication.ui.auth.AuthViewModel

class ViewModelFactory (
    private val repository : BaseRepository
) : ViewModelProvider.NewInstanceFactory()  {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(AuthViewModel::class.java) -> AuthViewModel(repository as AuthRepository) as T
            else -> throw java.lang.IllegalArgumentException("ViewModelClass Not Found")
        }

    }

}