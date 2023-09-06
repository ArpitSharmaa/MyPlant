package com.example.myplant

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras

class viewmodelfactory(private val context: Context):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return Viewmodel(context) as T
    }

//    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
//        return viewmodelfactory(context) as T
    }
