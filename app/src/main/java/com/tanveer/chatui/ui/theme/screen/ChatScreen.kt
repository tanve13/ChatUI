package com.example.chatui.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.tanveer.chatui.model.Message
import com.tanveer.chatui.ui.theme.components.ChatBubble
import com.tanveer.chatui.ui.theme.components.InputBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen() {
    val messages = remember { mutableStateListOf<Message>() }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("ChatUI") }
            )
        },
        bottomBar = {
            InputBar { text ->
                messages.add(Message(text = text, isUserMe = true))
                messages.add(Message(text = "Echo: $text", isUserMe = false))
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            reverseLayout = true
        ) {
            items(messages.reversed()) { message ->
                ChatBubble(message)
            }
        }
    }
}