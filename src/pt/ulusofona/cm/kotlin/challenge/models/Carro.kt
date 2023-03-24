package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel
import java.text.SimpleDateFormat

class Carro(override val identificador: String, var motor: Motor) : Veiculo(identificador = String()), Ligavel {

    override var posicao: Posicao = Posicao(0, 0)


    override fun requerCarta(): Boolean {
        return true
    }

    override fun moverPara(x: Int, y: Int) {
        if (estaLigado()) {
            this.posicao.alterarPosicaoPara(x, y)
            desligar()
        }else{
            ligar()
            this.posicao.alterarPosicaoPara(x,y)
            desligar()
        }

    }

    override fun toString(): String {
        return "Carro | ${identificador} | ${dataFormatada()} | $posicao"
    }

    fun dataFormatada(): String {
        val formato = SimpleDateFormat("dd-MM-yyyy")
        val dataModificada = formato.format(dataDeAquisicao)
        return dataModificada.toString()
    }

    override fun ligar() {
        this.motor.ligar()
    }

    override fun desligar() {
        this.motor.desligar()
    }

    override fun estaLigado(): Boolean {
        return this.motor.estaLigado()
    }
}