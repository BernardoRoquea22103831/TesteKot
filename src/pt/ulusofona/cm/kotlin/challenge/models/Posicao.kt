package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exception.AlterarPosicaoException

class Posicao(private var x: Int, private var y: Int)  {


    fun alterarPosicaoPara(x:Int,y: Int){
        if(this.x == x && this.y == y){
            throw AlterarPosicaoException()
        }
        this.x = x
        this.y=y
    }

    fun getPosicaoX():Int{
        return this.x
    }
    fun getPosicaoY():Int{
        return this.y
    }

    override fun toString(): String {
        return "Posicao | x:${getPosicaoX()} | y:${getPosicaoY()}"
    }

}