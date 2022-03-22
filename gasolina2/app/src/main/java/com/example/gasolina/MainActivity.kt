package com.example.gasolina

import android.R
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var edtgasolina: EditText? = null
    var edtalcool: EditText? = null
    var btnCalcular: Button? = null
    var txtResultado: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        carregaComponentes()
        configurarBotaoCalcular()
    }

    protected fun carregaComponentes() {
        edtgasolina = findViewById(R.id.edtgasolina)
        edtalcool = findViewById(R.id.edtalcool)
        btnCalcular = findViewById(R.id.btnCalcularPreco)
        txtResultado = findViewById(R.id.txtResultado)
    }

    protected fun configurarBotaoCalcular() {
        btnCalcular!!.setOnClickListener {
            val resultado = realizaCalculo()
            exibiResultado(resultado)
            limpaCampos()
        }
    }

    protected fun realizaCalculo(): String {
        val gasolina = edtgasolina!!.text.toString().toFloat()
        val alcool = edtalcool!!.text.toString().toFloat()
        val resultado: String
        val maior: Double


        maior = (gasolina * 0,7 ).toDouble()
        resultado = if (maior < alcool) {
            "Gasolina"
        } else if (maior > alcool) {
            "Alcool"
        } else {
            "Obesidade Grau III (Mórbida)"
        }
        return resultado
    }

    protected fun exibiResultado(resultado: String?) {
        txtResultado!!.text = resultado
    }

    protected fun limpaCampos() {
        edtAltura!!.setText("")
        edtPeso!!.setText("")
        edtPeso!!.requestFocus()
    }
}