package com.dio.nytbestsellerbookslist.data.response

import com.google.gson.annotations.SerializedName

data class BookResponse (

    @SerializedName("book_details") val bookdetails : List<BookDetails>
)