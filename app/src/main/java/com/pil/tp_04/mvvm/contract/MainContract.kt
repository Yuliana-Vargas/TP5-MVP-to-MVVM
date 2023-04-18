package com.pil.tp_04.mvvm.contract

import androidx.lifecycle.LiveData
import com.pil.tp_04.mvvm.viewmodel.MainViewModel

interface MainContract {
    interface Model {
        val counter: Int
        fun increment(inputValue: Int)
        fun decrement(inputValue: Int)
        fun reset()
    }

    interface ViewModel {
        fun getValue(): LiveData<MainViewModel.CounterData>
        fun resetValue()
        fun incValue(number: Int)
        fun decValue(number: Int)
    }
}
