package com.dio.nytbestsellerbookslist.data.response

import com.google.gson.annotations.SerializedName

data class BookDetails(

    @SerializedName("title") var title: String = "",
    @SerializedName("author") var author: String = ""
)