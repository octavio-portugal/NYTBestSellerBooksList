package com.dio.nytbestsellerbookslist.data.response

import com.google.gson.annotations.SerializedName

class BookDetails (

    @SerializedName("book_details") val bookdetails : List<BookInformations>
)