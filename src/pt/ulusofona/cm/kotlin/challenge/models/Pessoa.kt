package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import java.text.SimpleDateFormat
import java.util.*



class Pessoa(var nome: String, val dataDeNascimento: Date) {


    val veiculos = mutableListOf<Veiculo>()
    var carta: Carta? = null
    var posicao: Posicao = Posicao(0,0)


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


    }

    fun moverVeiculoPara(identificar: String, x: Int, y: Int) {
        val veiculo = pesquisarVeiculo(identificar)

        veiculo.posicao.alterarPosicaoPara(x, y)


    }

    fun temCarta(): Boolean {
        if (this.carta == null) {
            throw PessoaSemCartaException()
        }

        return true
    }

    fun calcularIdade(): Boolean {
        val now = Date()
        val idadeEmMiliseconds = now.time - dataDeNascimento.time
        val idadeEmAnos = idadeEmMiliseconds / 1000L / 60L / 60L / 24L / 365L
        return idadeEmAnos >= 18L
    }
    fun dataFormatada() : String {
        val formato = SimpleDateFormat("dd-MM-yyyy")
        val dataModificada = formato.format(dataDeNascimento)
        return dataModificada.toString()
    }

    fun tirarCarta() {
        if (calcularIdade()>=true) {
            this.carta = Carta()
        }
        throw PessoaSemCartaException()
    }

    override fun toString(): String {
        return "Pessoa | $nome | $dataDeNascimento | $posicao"
    }


}