package com.example.prueba.ui

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba.R

class MainActivity : AppCompatActivity() {

    private lateinit var radioGroupPlatillos: RadioGroup
    private lateinit var checkBoxPropina: CheckBox
    private lateinit var btnCalcularMonto: Button
    private lateinit var textViewResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioGroupPlatillos = findViewById(R.id.radioGroupPlatillos)
        checkBoxPropina = findViewById(R.id.checkBoxPropina)
        btnCalcularMonto = findViewById(R.id.btnCalcularMonto)
        textViewResultado = findViewById(R.id.textViewResultado)

        btnCalcularMonto.setOnClickListener { calcularMonto() }
    }

    private fun calcularMonto() {
        val platilloSeleccionado = findViewById<RadioButton>(radioGroupPlatillos.checkedRadioButtonId)
        val precioBase = when (platilloSeleccionado?.id) {
            R.id.radioButtonPastel -> 12000.0
            R.id.radioButtonCazuela -> 10000.0
            else -> 0.0
        }

        val incluirPropina = checkBoxPropina.isChecked
        val montoConPropina = if (incluirPropina) precioBase * 1.1 else precioBase

        textViewResultado.text = "Monto a pagar: $$montoConPropina"
    }
}