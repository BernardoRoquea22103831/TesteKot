package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.*


class Pessoa(var nome: String, val dataDeNascimento: Date) : Movimentavel {


    val veiculos = mutableListOf<Veiculo>()
    var carta: Carta? = null
    var posicao: Posicao = Posicao(0, 0)


    fun comprarVeiculo(veiculo: Veiculo) {
        this.veiculos.add(veiculo)
        veiculo.dataDeAquisicao = Date()
    }

    fun pesquisarVeiculo(identificar: String): Veiculo {
        for (veiculo in veiculos) {
            if (veiculo.identificador == identificar) {
                return veiculo
            }
        }
        throw VeiculoNaoEncontradoException()
    }

    fun venderVeiculo(identificar: String, comprador: Pessoa) {
        val veiculo = pesquisarVeiculo(identificar)

        this.veiculos.remove(veiculo)
        comprador.veiculos.add(veiculo)
        veiculo.dataDeAquisicao = Date.from(Instant.now())
        comprador.veiculos.add(veiculo)
    }

    override fun moverPara(x: Int, y: Int) {
        this.posicao.alterarPosicaoPara(x, y)
    }

    fun moverVeiculoPara(identificar: String, x: Int, y: Int) {
        val veiculo = pesquisarVeiculo(identificar)
        if (!temCarta() && veiculo.requerCarta()) {
            throw PessoaSemCartaException(this.nome)
        }
        veiculo.posicao.alterarPosicaoPara(x, y)
        moverPara(x,y)
    }

    fun temCarta(): Boolean {
        return this.carta != null
    }

    fun calcularIdade(): Boolean {
        val now = Date()
        val idadeEmMiliseconds = now.time - dataDeNascimento.time
        val idadeEmAnos = idadeEmMiliseconds / 1000L / 60L / 60L / 24L / 365L
        return idadeEmAnos >= 18L
    }

    fun dataFormatada(): String {
        val formato = SimpleDateFormat("dd-MM-yyyy")
        val dataModificada = formato.format(dataDeNascimento)
        return dataModificada.toString()
    }

    fun tirarCarta() {
        if (calcularIdade() >= true) {
            this.carta = Carta()
        }else{
            throw MenorDeIdadeException()
        }


    }

    override fun toString(): String {
        return "Pessoa | $nome | ${dataFormatada()} | $posicao"
    }


}