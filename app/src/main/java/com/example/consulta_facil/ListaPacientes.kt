package com.example.consulta_facil

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListaPacientes(
    val id: String? = null,
    val cpf: String? = null,
    val crm: String? = null,
    val password: String? = null,
    val name: String? = null,
): Parcelable
