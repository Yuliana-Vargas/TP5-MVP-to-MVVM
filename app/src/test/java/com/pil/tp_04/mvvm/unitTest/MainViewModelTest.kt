package com.pil.tp_04.mvvm.unitTest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.pil.tp_04.mvvm.contract.MainContract
import com.pil.tp_04.mvvm.model.MainModel
import com.pil.tp_04.mvvm.viewmodel.MainViewModel
import com.pil.tp_04.mvvm.viewmodel.MainViewModel.CounterState
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class MainViewModelTest {
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainContract.ViewModel

    @Before
    fun setup() {
        viewModel = MainViewModel(MainModel())
    }

    @Test
    fun `initial state`() {
        assert(viewModel.getValue().value == null)
    }

    @Test
    fun `on press the reset button after initial state`() {
        viewModel.resetValue()

        assert(viewModel.getValue().value != null)
        assert(viewModel.getValue().value?.state == CounterState.INITIAL)
        assert(viewModel.getValue().value?.value == ZERO)
    }

    @Test
    fun `on press the reset button after pressing the increment button`() {
        viewModel.incValue(FIVE)
        assert(viewModel.getValue().value?.value == FIVE)

        viewModel.resetValue()

        assert(viewModel.getValue().value != null)
        assert(viewModel.getValue().value?.state == CounterState.INITIAL)
        assert(viewModel.getValue().value?.value == ZERO)
    }

    @Test
    fun `on press the reset button after pressing the decrement button`() {
        viewModel.decValue(FIVE)
        assert(viewModel.getValue().value?.value == MINUS_FIVE)

        viewModel.resetValue()

        assert(viewModel.getValue().value != null)
        assert(viewModel.getValue().value?.state == CounterState.INITIAL)
        assert(viewModel.getValue().value?.value == ZERO)
    }

    @Test
    fun `on press the increment button after initial state`() {
        viewModel.incValue(FIVE)

        assert(viewModel.getValue().value != null)
        assert(viewModel.getValue().value?.state == CounterState.INC)
        assert(viewModel.getValue().value?.value == FIVE)
    }

    @Test
    fun `on press the increment button after pressing the decrement button`() {
        viewModel.decValue(FIVE)
        assert(viewModel.getValue().value?.value == MINUS_FIVE)

        viewModel.incValue(FIVE)

        assert(viewModel.getValue().value != null)
        assert(viewModel.getValue().value?.state == CounterState.INC)
        assert(viewModel.getValue().value?.value == ZERO)
    }

    @Test
    fun `on press the decrement button after initial state`() {
        viewModel.decValue(FIVE)

        assert(viewModel.getValue().value != null)
        assert(viewModel.getValue().value?.state == CounterState.DEC)
        assert(viewModel.getValue().value?.value == MINUS_FIVE)
    }

    @Test
    fun `on press the decrement button after pressing the increment button`() {
        viewModel.incValue(FIVE)
        assert(viewModel.getValue().value?.value == FIVE)

        viewModel.decValue(FIVE)

        assert(viewModel.getValue().value != null)
        assert(viewModel.getValue().value?.state == CounterState.DEC)
        assert(viewModel.getValue().value?.value == ZERO)
    }

    companion object {
        private const val ZERO = 0
        private const val FIVE = 5
        private const val MINUS_FIVE = -5
    }
}
