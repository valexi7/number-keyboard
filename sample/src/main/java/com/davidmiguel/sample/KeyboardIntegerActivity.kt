package com.davidmiguel.sample

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

import com.davidmiguel.numberkeyboard.NumberKeyboard
import com.davidmiguel.numberkeyboard.NumberKeyboardListener

import java.text.NumberFormat

class KeyboardIntegerActivity : AppCompatActivity(), NumberKeyboardListener {

    private lateinit var amountEditText: TextView
    private lateinit var numberKeyboard: NumberKeyboard
    private var amount: Int = 0
    private val nf = NumberFormat.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keyboard_integer)
        title = "Keyboard integer"
        amountEditText = findViewById(R.id.amount)
        numberKeyboard = findViewById(R.id.numberKeyboard)
        numberKeyboard.setListener(this)
        //numberKeyboard.setNumberKeyBackground(com.davidmiguel.numberkeyboard.R.drawable.numberkeyboard_key_bg_pressed)
        numberKeyboard.setNumberKeyTextColor(Color.BLACK)
        numberKeyboard.setNumberKeyBackgroundColor(Color.GRAY)
    }

    override fun onNumberClicked(number: Int) {
        val newAmount = (amount * 10.0 + number).toInt()
        if (newAmount <= MAX_ALLOWED_AMOUNT) {
            amount = newAmount
            showAmount()
            //numberKeyboard.setNumberKeyBackgroundColor(Color.YELLOW)
        }
    }

    override fun onLeftAuxButtonClicked() {
        // Nothing to do
    }

    override fun onRightAuxButtonClicked() {
        amount = (amount / 10.0).toInt()
        showAmount()
    }

    private fun showAmount() {
        amountEditText.text = nf.format(amount.toLong())
    }

    companion object {
        private const val MAX_ALLOWED_AMOUNT = 99999
    }
}
