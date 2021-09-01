package com.konet.konetpos

import com.squareup.moshi.Json

data class PrintObject(@Json(name = "Receipt") val printFields:
                       List<PrintField>)
data class PrintField(
    @Json(name = "Bitmap") val Bitmap: String,
    @Json(name = "letterSpacing") val letterSpacing: Int,
    @Json(name = "String") val stringFields: List<StringField>
)
data class StringField(
    @Json(name = "isMultiline") val isMultiline: Boolean,
    @Json(name = "header") val header: TextField,
    @Json(name = "body") val body: TextField
)
data class TextField(
    @Json(name = "text") val text: String,
    @Json(name = "align") val align: String,
    @Json(name = "size") val size: String?,
@Json(name = "isBold") val isBold: Boolean?
)


//val Merchantheader =
//    TextField(MerchantName, align = "centre", size = "large", isBold = true)
//val Merchantbody = TextField(
//    text = "Global Accelerex",
//    align = "right",
//    size = "normal",
//    isBold = true
//)

//val ReferenceNumberheader =
//    TextField(MerchantName, align = "centre", size = "large", isBold = true)
//val ReferenceNumberbody = TextField(
//    text = "Reference Number",
//    align = "right",
//    size = "normal",
//    isBold = false
//)
//
//val stringField = listOf(
//    StringField(true, Merchantheader, Merchantbody),
//    StringField(true, ReferenceNumberheader, ReferenceNumberbody)
//)
//val printField = listOf(PrintField("filename", 5, stringField))
//val buyGiftcardRequest = PrintObject(
//    printFields = printField
//)
//
//val jsonString = buyGiftcardRequest.toString()
//
//Snackbar.make(
//binding.root,
//"Yes print",
//Snackbar.LENGTH_LONG
//).show()