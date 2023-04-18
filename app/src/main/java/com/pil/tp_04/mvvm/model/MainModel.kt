package com.pil.tp_04.mvvm.model

import com.pil.tp_04.mvvm.contract.MainContract

class MainModel : MainContract.Model {
    override var counter: Int = 0
        private set

    override fun increment(inputValue: Int) {
        counter += inputValue
    }

    override fun decrement(inputValue: Int) {
        counter -= inputValue
    }

    override fun reset() {
        counter = 0
    }
}
