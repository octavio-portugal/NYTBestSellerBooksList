package com.dio.nytbestsellerbookslist.data.response

import com.dio.nytbestsellerbookslist.data.model.BookModel
import com.google.gson.annotations.SerializedName

abstract class BookBody (

    @SerializedName("results") var results : List<BookDetails>
) : List<BookModel>

class BookDetails (

    @SerializedName("book_details") val bookdetails : List<BookInformations>
)


class BookInformations(

    @SerializedName("title") var titulo: String = "",
    @SerializedName("author") var autor: String = ""
)

