package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var isNewop = true
    var numeroanterior = ""
    var op = "+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberEvent(view: View) {
        if(isNewop)
            editText.setText("")
        isNewop = false
        var botonclick = editText.text.toString()
        var botonseleccionar = view as Button
        when(botonseleccionar.id){
            Boton0.id -> {botonclick += "0"}
            Boton1.id -> {botonclick += "1"}
            Boton2.id -> {botonclick += "2"}
            Boton3.id -> {botonclick += "3"}
            Boton4.id -> {botonclick += "4"}
            Boton5.id -> {botonclick += "5"}
            Boton6.id -> {botonclick += "6"}
            Boton7.id -> {botonclick += "7"}
            Boton8.id -> {botonclick += "8"}
            Boton9.id -> {botonclick += "9"}
            Botonpunto.id ->{botonclick += "."}
           

        }
        editText.setText(botonclick)
    }

    fun operatorEvent(view: View) {
        isNewop = true
        numeroanterior = editText.text.toString()
        var botonseleccionar = view as Button
        when(botonseleccionar.id){
            Botonmas.id -> {op = "+"}
            Botonmenos.id -> {op = "-"}
            BotonMultiplicacion.id -> {op = "*"}
            BotonDivision.id -> {op = "/"}
        }

    }

    fun equalEvent(view: View) {
        var nuevonumero = editText.text.toString()
        var resultado = 0.0
        when(op){
            "+" -> {resultado = numeroanterior.toDouble() + nuevonumero.toDouble()}
            "-" -> {resultado = numeroanterior.toDouble() - nuevonumero.toDouble()}
            "*" -> {resultado = numeroanterior.toDouble() * nuevonumero.toDouble()}
            "/" -> {resultado = numeroanterior.toDouble() / nuevonumero.toDouble()}
        }
        editText.setText(resultado.toString())
    }

    fun acEvent(view: View) {
        editText.setText("0")
        isNewop = true
    }

    fun percentEvent(view: View) {
        var percent = editText.text.toString().toDouble()/100
        editText.setText(percent.toString())
        isNewop = true
    }
}