package com.tanveer.chatui.model

data class Message(val text:String,
val isUserMe:Boolean,
val timeStamp: Long = System.currentTimeMillis())
