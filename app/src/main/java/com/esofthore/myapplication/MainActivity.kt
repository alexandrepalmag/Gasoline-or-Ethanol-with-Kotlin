package com.esofthore.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import java.util.*
import java.util.Locale.*
import kotlin.String.Companion as String1

class MainActivity : AppCompatActivity() {
    var valueGasoline = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //loading components
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val txtGasoline = findViewById<TextView>(R.id.txtGasoline)
        val txtResult = findViewById<TextView>(R.id.txtResult)
        val btn = findViewById<Button>(R.id.btnCalculate)

        // maxim size seekBar
        seekBar.max = 1000
        //listener to seekBar
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                TODO("Not yet implemented")
                valueGasoline = progress
                var text = "$ "
                text += formatValue(valueGasoline / 100.0)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
                txtResult.text = "Select the price of gasoline!"
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
                txtResult.text = "Click calculate to see the result"
            }

        })

        // button's listener
        btn.setOnClickListener {
            var valueResult = (valueGasoline * 0.7)/100.0
            var text = "Refill with ethanol if it costs up to: $ "
            text += formatValue(valueResult)
            txtResult.text = text

        }

    }

    private fun formatValue(value: Double): Any? {
        return String.format(Locale.US, format = "%.2f")
    }
}


