package com.example.consulta_facil

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BuscadorIAActivity : AppCompatActivity() {
    private lateinit var etInput: EditText
    private lateinit var btnSend: Button
    private lateinit var rvChat: RecyclerView
    private val chatMessages = mutableListOf<ChatMessage>()
    private lateinit var chatAdapter: ChatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscador_ia)

        etInput = findViewById(R.id.et_input)
        btnSend = findViewById(R.id.btn_send)
        rvChat = findViewById(R.id.rv_chat)

        // Configurar RecyclerView
        chatAdapter = ChatAdapter(chatMessages)
        rvChat.layoutManager = LinearLayoutManager(this)
        rvChat.adapter = chatAdapter

        btnSend.setOnClickListener {
            val userMessage = etInput.text.toString()
            if (userMessage.isNotEmpty()) {
                addMessage(userMessage, isUser = true)
                fetchChatbotResponse(userMessage)
                etInput.text.clear()
            }
        }
    }

    private fun addMessage(text: String, isUser: Boolean) {
        chatMessages.add(ChatMessage(text, isUser))
        chatAdapter.notifyItemInserted(chatMessages.size - 1)
        rvChat.scrollToPosition(chatMessages.size - 1)
    }

    private fun fetchChatbotResponse(userMessage: String) {
        // Substituir com chamada real ao modelo Gemini
        val fakeResponse = "Aqui está uma resposta simulada para: $userMessage"
        addMessage(fakeResponse, isUser = false)
    }
}