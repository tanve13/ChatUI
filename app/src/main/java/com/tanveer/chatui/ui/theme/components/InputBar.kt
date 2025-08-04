package com.tanveer.chatui.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputBar(onSend: (String) -> Unit) {
    var messageText by remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.White),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(value = messageText, onValueChange = { messageText = it },
            modifier = Modifier.weight(1f),
            placeholder = { Text(text = "Type a message") },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
        Button(
            onClick = {
                if (messageText.isNotBlank()) {
                    onSend(messageText)
                    messageText = ""

                }

            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue, // Button ka background color
                contentColor = Color.White   // Text ka color
            )
        ) {
            Text(text = "Send")
        }
    }
}