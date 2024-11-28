package com.example.consulta_facil

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Medicamento(
    val nome: String,
    val periodicidade: String,
    val dias: String // Add other properties as needed
): Parcelable