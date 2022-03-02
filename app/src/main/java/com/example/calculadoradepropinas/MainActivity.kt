package com.example.calculadoradepropinas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.calculadoradepropinas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //tarer los elementos graficos desde el codigo
    //lateinit
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI(){
        binding.button15.setOnClickListener {
            interfaceCalculateTip(percentage = .15)
            sendToaster("seleccionaste ${binding.button15.text.toString()}")
        }
        binding.button25.setOnClickListener {
            interfaceCalculateTip(percentage = .25)
            sendToaster("seleccionaste ${binding.button25.text.toString()}")
        }
        binding.button35.setOnClickListener {
            interfaceCalculateTip(percentage = .35)
            sendToaster("seleccionaste ${binding.button35.text.toString()}")
        }
    }
    private fun interfaceCalculateTip(percentage: Double){
        //esto es para para obtner el valor de ese elemento toString y te lo trae como cadena y te lo pasa en double
        val amount = binding.editTextNumberDecimal.text.toString()
        //este toDOubleOrNull es para validar si esta en nulo a hay un valor
        val amountValue = amount.toDoubleOrNull()

        if(amountValue == null || amountValue == 0.0 || amountValue <= 0.0){
            sendToaster("error intenta otra cantidad")
            return
        }
        binding.totalTip.text = "${ amountValue * percentage}"
        binding.totalAmount.text = "${amountValue * (1 + percentage)}"

        binding.buttonRedondear.setOnClickListener {

            redondear(amountValue * percentage)
        }


    }

    private fun redondear(cantidad: Double){


        if (cantidad == null){
            binding.totalTipRound.text = " "
        }
        binding.totalTipRound.text = "${Math.round(cantidad)}"

    }

    private fun sendToaster(mensaje: String){
        Toast.makeText(this, " ${mensaje}", Toast.LENGTH_LONG).show()
    }
}