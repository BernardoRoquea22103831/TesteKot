package pt.ulusofona.cm.kotlin.challenge.exceptions

class PessoaSemCartaException(val nome:String):Exception("$nome Não tem carta") {
}