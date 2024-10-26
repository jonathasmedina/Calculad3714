package com.example.calculadora3714

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edNum1 = findViewById<EditText>(R.id.editTextNum1)
        val edNum2 = findViewById<EditText>(R.id.editTextNum2)

        val buttonSoma = findViewById<Button>(R.id.buttonSomar)
        val buttonSubt = findViewById<Button>(R.id.buttonSubtrair)
        val buttonMultiplicar = findViewById<Button>(R.id.buttonMult)
        val buttonDivivir = findViewById<Button>(R.id.buttonDiv)
        val buttonLimparCampos = findViewById<Button>(R.id.buttonLimpar)

        val tvResult = findViewById<TextView>(R.id.textView)

        buttonSoma.setOnClickListener {
            if(!camposVazios()){
                var num1 = edNum1.text.toString().toDouble()
                var num2 = edNum2.text.toString().toDouble()

                var resultado = num1+num2
                tvResult.text = "O resultado é " + String.format("%.2f", resultado)
            }
        }

        buttonSubt.setOnClickListener {
            if(!camposVazios()){
                var num1 = edNum1.text.toString().toDouble()
                var num2 = edNum2.text.toString().toDouble()

                var resultado = num1-num2

                tvResult.text = "O resultado é " + String.format("%.2f", resultado)
            }
        }

        buttonMultiplicar.setOnClickListener {
            if(!camposVazios()){
                var num1 = edNum1.text.toString().toDouble()
                var num2 = edNum2.text.toString().toDouble()

                var resultado = num1*num2

                tvResult.text = "O resultado é " + String.format("%.2f", resultado)
            }
        }

        buttonDivivir.setOnClickListener {
            if(!camposVazios()){
                var num1 = edNum1.text.toString().toDouble()
                var num2 = edNum2.text.toString().toDouble()

                if(num2 == 0.0)
                    edNum2.error = "Este número não pode ser zero."
                else{
                    var resultado = num1/num2
                    tvResult.text = "O resultado é " + String.format("%.2f", resultado)

                }

            }
        }

        buttonLimparCampos.setOnClickListener {
            edNum2.text.clear()
            edNum1.text.clear()
        }


    }

    private fun camposVazios(): Boolean {
        val edNum1 = findViewById<EditText>(R.id.editTextNum1)
        val edNum2 = findViewById<EditText>(R.id.editTextNum2)
        var retorno = false;
        if(edNum1.text.isEmpty()){
            edNum1.error = "Preencha!"
            retorno = true
        }
        if(edNum2.text.isEmpty()){
            edNum2.error = "Preencha!"
            retorno = true
        }
        return retorno


    }
}