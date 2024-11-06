package com.example.consulta_facil

import java.io.Serializable

data class DadosUsuario(
    var id: String = "",
    var nome: String = "",
    var cpf: String = "",
    var crm: String = "",
    var senha: String = "",
) : Serializable
