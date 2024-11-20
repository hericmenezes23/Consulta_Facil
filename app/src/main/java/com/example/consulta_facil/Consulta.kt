package com.example.consulta_facil

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Consulta(
    val id: String? = null,
    val nomeMedico: String? = null,
    val especialidade: String? = null,
    val data: String? = null,
    val endereco: String? = null,
) : Parcelable
