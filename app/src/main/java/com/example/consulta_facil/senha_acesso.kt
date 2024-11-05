package com.example.consulta_facil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class senha_acesso : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_senha_acesso)
        val bt_senha = findViewById<Button>(R.id.EntrarSenha)
        val senha = findViewById<EditText>(R.id.SenhaView)
        var fb = Firebase.firestore

        bt_senha.setOnClickListener {
            //Toast.makeText(this, cpfCampo.text.toString(), Toast.LENGTH_SHORT).show()
            fb.collection("usuarios").get()
                .addOnSuccessListener { docs ->
                    Toast.makeText(this, "sucess", Toast.LENGTH_SHORT).show()

                    for (doc in docs) {
                        if (doc.get("user") == senha.text.toString()) {
                            Toast.makeText(
                                this, "Usuario ja existe",
                                Toast.LENGTH_LONG
                            ).show()
                            break
                        }

                    }

                }.addOnFailureListener { exception ->
                    Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
                }
        }
    }
}