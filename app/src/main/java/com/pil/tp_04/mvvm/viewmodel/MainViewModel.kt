package com.pil.tp_04.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pil.tp_04.mvvm.contract.MainContract

class MainViewModel(private val model: MainContract.Model) : ViewModel(), MainContract.ViewModel {

    private val mutableLiveData: MutableLiveData<CounterData> = MutableLiveData()
    override fun getValue(): LiveData<CounterData> {
        return mutableLiveData
    }

    override fun resetValue() {
        model.reset()
        mutableLiveData.postValue(CounterData(CounterState.INITIAL))
    }

    override fun incValue(number: Int) {
        model.increment(number)
        mutableLiveData.postValue(CounterData(CounterState.INC, model.counter))
    }

    override fun decValue(number: Int) {
        model.decrement(number)
        mutableLiveData.postValue(CounterData(CounterState.DEC, model.counter))
    }

    data class CounterData(
        val state: CounterState = CounterState.INITIAL,
        val value: Int = 0,
    )

    enum class CounterState {
        INITIAL,
        INC,
        DEC,
    }
}
