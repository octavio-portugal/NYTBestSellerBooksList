package com.dio.nytbestsellerbookslist.data

import com.dio.nytbestsellerbookslist.data.response.BookBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NytAPI{

    @GET ("lists.json")
    fun ListBooks(
        @Query("api-key") apikey: String = "FVWR9iNfBhiZIgnvCOa4dLjX6ucfK9Wb",
        @Query("list") list: String = "hardcover-fiction"
    ): Call<BookBody>
}

    fun retrotif(): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.nytimes.com/svc/books/v3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()