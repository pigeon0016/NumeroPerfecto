package com.example.numeroperfecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.numeroperfecto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setSupportActionBar(binding.toolbar)
    }

    fun click(view: View) {            // si no escribe nada 1) se verifica que haya data
        if (validacampos()) {
            val numero = Integer.parseInt(binding.etNumero.text.toString())
            numeroperfecto(numero)

        //if (numeroperfecto(numero)) binding.tvResultado.text = "El numero $numero si es primo"
           // else binding.tvResultado.text = "el numero $numero no es primo"


        } else {
            Toast.makeText(this, "porfavor ingrese numero", Toast.LENGTH_LONG).show()
            binding.etNumero.error = "se requiere dato"
            binding.etNumero.requestFocus()
            //para hacer una vsita desparezca y aparezca
            //binding.etNumero.visibility = View.INVISIBLE
            //binding.etNumero.visibility = View.VISIBLE
        }
    }

    //funcion
   /* private fun esPrimo(numero: Int): Boolean{
        if (numero <= 1) return false
        else{
            for(i in 2 until numero){
                if (numero%1 == 0) return false
            }
        }
        return true
    }
*/

    // valida que el campo del numero tenga info
    private fun validacampos(): Boolean{
        if(binding.etNumero.text.toString() == "") return false
        else return true
    }

    private fun numeroperfecto(numero1: Int) {
        var sum = 0

        for (i in  1..numero1 / 2){
            if (numero1 % i == 0){
                sum += i
            }
        }
      if (sum == numero1){
          binding.tvResultado.text = "es Perfecto"
      }else{
          binding.tvResultado.text = "No es Perfecto"
      }


    }





}





