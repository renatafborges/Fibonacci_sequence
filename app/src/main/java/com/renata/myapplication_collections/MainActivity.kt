package com.renata.myapplication_collections

//BIBLIOTECAS
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

//DECLARAR VARIÁVEIS E COMPONENTES
// FIBONACCI SEQUENCES 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89
//cada número é a somatória dos dois antecessores

    lateinit var inserirNumero: EditText
    lateinit var calcular: Button
    lateinit var resultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//INICIALIZAR O COMPONENTE, VINCULAR O XML COM O CÓDIGO

        inserirNumero = findViewById(R.id.edtInserir)
        calcular = findViewById(R.id.btnCalcular)
        resultado = findViewById(R.id.txtResultado)

//TUDO A SER EXECUTADO SERÁ SOMENTE QUANDO O USUÁRIO TOCAR NO BOTÃO // estrutura de condição

        calcular.setOnClickListener {

            val sequenciaNumeros = inserirNumero.text.toString()

            if (sequenciaNumeros.isNotEmpty()){
                    sequenciaFibonacci(sequenciaNumeros.toInt())
            } else {
                inserirNumero?.error ="Informe um número"
            }
        }
    }

///DECLARAR AS FUNÇÕES E PARÂMETROS
    //inteiro or Nullabal?
    //a verificação do nulo antes de chamar a função

        fun sequenciaFibonacci(sequenciaNumeros: Int) {

//CONDIÇÃO INICIAL // "SEMENTE" *seeds*// valores iniciais
            var serie = ""
            var anterior: Long = 0
            var proximo: Long = 1

//CONDIÇÃO PARA EXECUÇÃO DA SEQUENCIA
            if (sequenciaNumeros == 0){
                serie = "$anterior"
            } else if (sequenciaNumeros == 1){
                serie = "$proximo"
            } else {
                serie = "$anterior, $proximo"
            }
//LAÇO DE REPETIÇÃO PARA PERCORRER COLEÇÕES
            for (contador in 1..sequenciaNumeros) {
                val soma = anterior + proximo
                anterior = proximo
                proximo = soma
                serie += ", $soma"
            }
            resultado.text = "A sequência de Fibonacci é $serie"
        }
    }

///regra da scrollview
//xml namespace dentro dele
