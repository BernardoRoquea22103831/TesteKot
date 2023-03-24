package pt.ulusofona.cm.kotlin.challenge.models

import java.text.SimpleDateFormat

class Bicicleta(override val identificador: String):Veiculo(identificador = String() ) {

    override var posicao:Posicao = Posicao(0,0)

    override fun requerCarta(): Boolean {
        return false
    }

    override fun moverPara(x: Int, y: Int) {

        this.posicao.alterarPosicaoPara(x,y)
    }
    fun dataFormatada() : String {
        val formato = SimpleDateFormat("dd-MM-yyyy")
        val dataModificada = formato.format(dataDeAquisicao)
        return dataModificada.toString()
    }

    override fun toString(): String {
        return "Bicicleta | $identificador | ${dataFormatada()} | $posicao"
    }


}