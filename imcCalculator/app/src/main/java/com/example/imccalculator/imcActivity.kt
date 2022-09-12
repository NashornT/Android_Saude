package com.example.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.view.doOnNextLayout
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputEditText
import kotlin.math.roundToInt

class imcActivity : AppCompatActivity(R.layout.activity_imc) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var alturas: MutableList<Any> = mutableListOf()
        var pesos: MutableList<Any> = mutableListOf()

        lateinit var altura:Any
        lateinit var peso: Any


        val button = findViewById<Button>(R.id.btn_verificar)
        val inputPeso = findViewById<TextInputEditText>(R.id.txtPeso)
        val inputAltura = findViewById<TextInputEditText>(R.id.txtAltura)
        var resultado = findViewById<TextView>(R.id.txt_Resultado)

        button.isEnabled = false


        inputPeso.doAfterTextChanged{
            peso = it.toString()
        }

        inputAltura.doAfterTextChanged {
            altura = it.toString()

            if(peso.toString().isNotEmpty() && altura.toString().length > 2 ){
                button.isEnabled = true
            }



        }







        button.setOnClickListener {

            val alturaValor = altura.toString().toDouble()
            val pesoValor = peso.toString().toDouble()
            val conta = pesoValor / (alturaValor.times(alturaValor))

            var imc: String

            if (conta < 16) {
                imc = "Magreza grave"
            } else if (conta > 16 && conta < 17) {
                imc = "Magreza moderada"
            } else if (conta > 17 && conta < 18.5) {
                imc = "Magreza leve"
            } else if (conta > 18.5 && conta < 25) {
                imc = "Saudável"
            } else if (conta > 25 && conta < 30) {
                imc = "Sobrepeso"
            } else if (conta > 30 && conta < 35) {
                imc = "Obesidade Grau I"
            } else if (conta > 35 && conta < 40) {
                imc = "Obesidade Grau II (severa)"
            } else {
                imc = "Obesidade Grau III (mórbida)"
            }



            resultado.setText("IMC: ${conta.roundToInt()} , $imc")
        }

    }

    // TODO: ("Terminar de implementar está função, para o codigo ficar mais limpo")
//    fun imc(btn:Button,alt:Any,ps:Any,reslt:TextView){
//
//        btn.setOnClickListener {
//
//            val alturaValor = alt.toString().toDouble()
//            val pesoValor = ps.toString().toDouble()
//            val conta = pesoValor/(alturaValor.times(alturaValor))
//
//            var imc:String
//
//            if(conta < 16 ){
//                imc = "Magreza grave"
//            }else if(conta> 16 && conta < 17) {
//                imc = "Magreza moderada"
//            }else if (conta>17 && conta < 18.5){
//                imc = "Magreza leve"
//            }else if (conta > 18.5 && conta < 25){
//                imc = "Saudável"
//            }else if (conta > 25 && conta < 30){
//                imc = "Sobrepeso"
//            }else if (conta > 30 && conta < 35){
//                imc = "Obesidade Grau I"
//            }else if (conta > 35 && conta < 40){
//                imc = "Obesidade Grau II (severa)"
//            }else{
//                imc = "Obesidade Grau III (mórbida)"
//            }
//
//
//
//            reslt.setText("IMC: ${conta.roundToInt()} , $imc")
//        }
//
//
//
//    }


}