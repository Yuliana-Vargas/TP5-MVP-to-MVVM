package com.pil.tp_04.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pil.tp_04.databinding.ActivityMainBinding
import com.pil.tp_04.mvvm.model.MainModel
import com.pil.tp_04.mvvm.viewmodel.MainViewModel
import com.pil.tp_04.mvvm.viewmodel.MainViewModel.CounterData
import com.pil.tp_04.mvvm.viewmodel.MainViewModel.CounterState

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel = MainViewModel(MainModel())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.increment.setOnClickListener { mainViewModel.incValue(getInputValue()) }
        binding.decrement.setOnClickListener { mainViewModel.decValue(getInputValue()) }
        binding.reset.setOnClickListener { mainViewModel.resetValue() }
        mainViewModel.resetValue()
        mainViewModel.getValue().observe({ lifecycle }, ::updateUI)
    }

    private fun updateUI(data: CounterData) {
        when (data.state) {
            CounterState.INITIAL -> {
                binding.counter.text = data.value.toString()
                clear()
            }
            CounterState.INC -> {
                binding.counter.text = data.value.toString()
            }
            CounterState.DEC -> {
                binding.counter.text = data.value.toString()
            }
        }
    }

    private fun getInputValue(): Int = binding.inputCount.text.toString().toInt()

    private fun clear() {
        binding.inputCount.text.clear()
    }
}
