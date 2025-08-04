package com.tanveer.chatui.ui.theme.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tanveer.chatui.model.Message
import com.tanveer.chatui.ui.theme.utils.TimeUtils

@Composable
fun ChatBubble(message: Message){
    val alignment = if (message.isUserMe) Alignment.End else Alignment.Start
    val bubbleColor = if (message.isUserMe) Color.White else Color.White
    val textColor= if (message.isUserMe) Color.Black else Color.Black
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp), horizontalAlignment = alignment) {
        Column(
            modifier = Modifier
                .background(bubbleColor, shape = RoundedCornerShape(12.dp))
                .padding(12.dp)
                .widthIn(max = 280.dp)
        ) {
            Text(text = message.text, color = textColor,
            style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text= TimeUtils.formatTimestamp(message.timeStamp),
                color = Color.Gray,
                style = MaterialTheme.typography.labelSmall,
                modifier=Modifier.align(Alignment.End)
            )

        }

    }





}