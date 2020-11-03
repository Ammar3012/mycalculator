package com.myammar.mycalculator

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.button.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Button number
        btn_0.setOnClickListener { appendOnInput("0",true) }
        btn_1.setOnClickListener { appendOnInput("1",true) }
        btn_2.setOnClickListener { appendOnInput("2",true) }
        btn_3.setOnClickListener { appendOnInput("3",true) }
        btn_4.setOnClickListener { appendOnInput("4",true) }
        btn_5.setOnClickListener { appendOnInput("5",true) }
        btn_6.setOnClickListener { appendOnInput("6",true) }
        btn_7.setOnClickListener { appendOnInput("7",true) }
        btn_8.setOnClickListener { appendOnInput("8",true) }
        btn_9.setOnClickListener { appendOnInput("9",true) }
        btn_period.setOnClickListener { appendOnInput(".",true) }

        // Operators
        btn_plus.setOnClickListener { appendOnInput("+", false) }
        btn_min.setOnClickListener { appendOnInput("-", false) }
        btn_kali.setOnClickListener { appendOnInput("*", false) }
        btn_div.setOnClickListener { appendOnInput("/", false) }
        btn_pangkat.setOnClickListener {  appendOnInput("^2", false) }
        btn_akar.setOnClickListener { akar()  }
        btn_round.setOnClickListener { round() }
        btn_ceil.setOnClickListener { ceiling() }
        btn_floor.setOnClickListener { floor() }

        btn_clear.setOnClickListener {
            tvInput.text = ""
        }
        btn_clear_all.setOnClickListener {
            tvInput.text = ""
            tvOutput.text = ""
        }

        btn_enter.setOnClickListener {

            try {
                val input = ExpressionBuilder(tvInput.text.toString()).build()
                val output = input.evaluate()
                val longOutput = output.toLong()
                if(output == longOutput.toDouble())
                    tvOutput.text = longOutput.toString()
                else {
                    tvOutput.text = output.toString()
                }
            } catch (e:Exception) {
             Log.d("Exception","pesan :" + e.message)
            }

        }
    }

    private fun appendOnInput ( string: String, canClear : Boolean){

        if (tvOutput.text.isNotEmpty()){
            tvInput.text= ""
        }
        if(canClear){
            tvOutput.text = ""
            tvInput.append(string)
        } else {
            tvInput.append(tvOutput.text)
            tvInput.append(string)
            tvOutput.text = ""
        }
    }

    private fun round() {
        try {
            if (tvInput.text.isNotEmpty()){
                var num = tvInput.text.toString()
                tvOutput.text = (Math.round(num.toDouble()*10.0/10.0)).toString()
                tvInput.text = ""
            } else {
                var num = tvInput.text.toString()
                tvOutput.text= (Math.round(num.toDouble()*10.0/10.0)).toString()
            }
        } catch (e:Exception){
            tvOutput.text = ""
            tvInput.text = ""
            Toast.makeText(this, "Insert the Number", Toast.LENGTH_SHORT).show()
        }
    }
    private fun ceiling() {
        try {
            if (tvInput.text.isNotEmpty()){
                var num = tvInput.text.toString()
                tvOutput.text = Math.ceil(num.toDouble()).toInt().toString()
                tvInput.text = ""
            } else {
                var num = tvInput.text.toString()
                tvOutput.text= Math.ceil(num.toDouble()).toInt().toString()
            }
        } catch (e:Exception){
            tvOutput.text = ""
            tvInput.text = ""
            Toast.makeText(this, "Insert the Number", Toast.LENGTH_SHORT).show()
        }
    }
    private fun floor() {
        try {
            if (tvInput.text.isNotEmpty()){
                var num = tvInput.text.toString()
                tvOutput.text = Math.floor(num.toDouble()).toInt().toString()
                tvInput.text = ""
            } else {
                var num = tvInput.text.toString()
                tvOutput.text= Math.floor(num.toDouble()).toInt().toString()
            }
        } catch (e:Exception){
            tvOutput.text = ""
            tvInput.text = ""
            Toast.makeText(this, "Insert the Number", Toast.LENGTH_SHORT).show()
        }
    }
    private fun akar() {
        try {
            if (tvInput.text.isNotEmpty()){
                var num = tvInput.text.toString()
                tvOutput.text = Math.sqrt(num.toDouble()).toFloat().toString()
                tvInput.text = ""
            } else {
                var num = tvInput.text.toString()
                tvOutput.text= Math.sqrt(num.toDouble()).toFloat().toString()
            }
        } catch (e:Exception){
            tvOutput.text = ""
            tvInput.text = ""
            Toast.makeText(this, "Insert the Number", Toast.LENGTH_SHORT).show()
        }
    }
}