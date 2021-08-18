package com.konet.konetpos

data class PrintObject(val Receipt:
                       List<PrintField>)
data class PrintField(
    val Bitmap: String,
    val letterSpacing: Int,
    val String: List<StringField>
)
data class StringField(
    val isMultiline: Boolean,
    val header: TextField,
    val body: TextField
)
data class TextField(
    val text: String,
   val align: String,
   val size: String?,
    val isBold: Boolean?
)