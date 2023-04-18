package com.pil.tp_04.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pil.tp_04.databinding.ActivityMainBinding
import com.pil.tp_04.mvvm.model.MainModel
import com.pil.tp_04.mvvm.viewmodel.MainViewModel

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

    private fun updateUI(data: MainViewModel.CounterData) {
        when (data.state) {
            MainViewModel.CounterState.INITIAL -> {
                binding.counter.text = data.value.toString()
                clear()
            }
            MainViewModel.CounterState.INC -> {
                binding.counter.text = data.value.toString()
            }
            MainViewModel.CounterState.DEC -> {
                binding.counter.text = data.value.toString()
            }
        }
    }

    private fun getInputValue(): Int = binding.inputCount.text.toString().toInt()

    private fun clear() {
        binding.inputCount.text.clear()
    }
}
