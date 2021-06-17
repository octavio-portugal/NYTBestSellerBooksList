package com.dio.nytbestsellerbookslist.data.response

import com.google.gson.annotations.SerializedName

data class BookBody (

    @SerializedName("results") var results : MutableList<BookResponse>
)