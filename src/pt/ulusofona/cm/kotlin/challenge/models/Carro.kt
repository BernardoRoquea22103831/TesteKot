package pt.ulusofona.cm.kotlin.challenge.models

import java.text.SimpleDateFormat

class Carro(override val identificador: String, motor: Motor) : Veiculo(identificador = String()) {

    override var posicao: Posicao = Posicao(0,0)

    override fun requerCarta(): Boolean {
        TODO("Not yet implemented")
    }

    override fun moverPara(x: Int, y: Int) {
        this.posicao.alterarPosicaoPara(x,y)
    }

    override fun toString(): String {
        return "Carro | ${identificador} |  | ${dataFormatada()} | $posicao"
    }
    fun dataFormatada() : String {
        val formato = SimpleDateFormat("dd-MM-yyyy")
        val dataModificada = formato.format(dataDeAquisicao)
        return dataModificada.toString()
    }


}