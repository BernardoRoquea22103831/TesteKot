package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.util.*

abstract class Veiculo(open val identificador:String):Movimentavel {

    open lateinit var posicao:Posicao
    var dataDeAquisicao :Date = Date()

    abstract fun requerCarta():Boolean


    @JvmName("getIdentificador1")
    fun getIdentificador() : String{
        return this.identificador
    }

}