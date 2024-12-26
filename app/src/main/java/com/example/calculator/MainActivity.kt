package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    private lateinit var resultView: EditText
    private var currentInput = ""
    private var operator: String? = null
    private var firstNumber: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultView = findViewById(R.id.result)

        
        val button1: Button = findViewById(R.id.button_1)
        val button2: Button = findViewById(R.id.button_2)
        val button3: Button = findViewById(R.id.button_3)
        val button4: Button = findViewById(R.id.button_4)
        val button5: Button = findViewById(R.id.button_5)
        val button6: Button = findViewById(R.id.button_6)
        val button7: Button = findViewById(R.id.button_7)
        val button8: Button = findViewById(R.id.button_8)
        val button9: Button = findViewById(R.id.button_9)
        val button0: Button = findViewById(R.id.button_0)


        val buttonAdd: Button = findViewById(R.id.button_add)
        val buttonSubtract: Button = findViewById(R.id.button_subtract)
        val buttonMultiply: Button = findViewById(R.id.button_multiply)
        val buttonDivide: Button = findViewById(R.id.button_divide)
        val buttonMod: Button = findViewById(R.id.button_mod)
        val buttonSquare: Button = findViewById(R.id.button_square)
        val buttonSqrt: Button = findViewById(R.id.button_sqrt)


        val buttonClear: Button = findViewById(R.id.button_clear)


        val buttonEquals: Button = findViewById(R.id.button_equals)

        button1.setOnClickListener { appendToInput("1") }
        button2.setOnClickListener { appendToInput("2") }
        button3.setOnClickListener { appendToInput("3") }
        button4.setOnClickListener { appendToInput("4") }
        button5.setOnClickListener { appendToInput("5") }
        button6.setOnClickListener { appendToInput("6") }
        button7.setOnClickListener { appendToInput("7") }
        button8.setOnClickListener { appendToInput("8") }
        button9.setOnClickListener { appendToInput("9") }
        button0.setOnClickListener { appendToInput("0") }


        buttonAdd.setOnClickListener { setOperator("+") }
        buttonSubtract.setOnClickListener { setOperator("-") }
        buttonMultiply.setOnClickListener { setOperator("*") }
        buttonDivide.setOnClickListener { setOperator("/") }
        buttonMod.setOnClickListener { setOperator("%") }
        buttonSquare.setOnClickListener { square() }
        buttonSqrt.setOnClickListener { sqrt() }


        buttonClear.setOnClickListener {
            resultView.setText("")
            currentInput = ""
            operator = null
            firstNumber = null
        }

        // Вычисление результата
        buttonEquals.setOnClickListener { calculateResult() }
    }

    private fun appendToInput(value: String) {
        currentInput += value
        resultView.setText(currentInput)
    }

    private fun setOperator(op: String) {
        if (currentInput.isNotEmpty()) {
            firstNumber = currentInput.toDouble()
            operator = op
            currentInput = ""
        }
    }

    private fun calculateResult() {
        if (currentInput.isNotEmpty() && firstNumber != null && operator != null) {
            val secondNumber = currentInput.toDouble()
            val result = when (operator) {
                "+" -> firstNumber!! + secondNumber
                "-" -> firstNumber!! - secondNumber
                "*" -> firstNumber!! * secondNumber
                "/" -> if (secondNumber != 0.0) firstNumber!! / secondNumber else Double.NaN
                "%" -> firstNumber!! % secondNumber
                else -> 0.0
            }

            resultView.setText(result.toString())
            currentInput = result.toString()
            firstNumber = null
            operator = null
        }
    }

    private fun square() {
        if (currentInput.isNotEmpty()) {
            val number = currentInput.toDouble()
            val result = number * number
            resultView.setText(result.toString())
            currentInput = result.toString()
        }
    }

    private fun sqrt() {
        if (currentInput.isNotEmpty()) {
            val number = currentInput.toDouble()
            val result = sqrt(number)
            resultView.setText(result.toString())
            currentInput = result.toString()
        }
    }
}
