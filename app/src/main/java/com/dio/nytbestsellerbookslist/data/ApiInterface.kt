package com.dio.nytbestsellerbookslist.data

import com.dio.nytbestsellerbookslist.data.model.BookModel
import com.dio.nytbestsellerbookslist.data.response.BookBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

 val listTipo= "hardcover-fiction"
 val apiChave = "FVWR9iNfBhiZIgnvCOa4dLjX6ucfK9Wb"

interface ApiInterface {
    @GET("list.json?api-key=yourkey")
    fun getBooks(
        @Query("yourkey") apiChave: String ="FVWR9iNfBhiZIgnvCOa4dLjX6ucfK9Wb",
        @Query("list") listTipo: String = "hardcover-fiction"
    ): Call<BookBody>

    companion object {
        val BASE_URL = "https://api.nytimes.com/svc/books/v3/lists/current/"

        fun iniciaRetrofit(): ApiInterface? {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiInterface::class.java)

        }

    }
}

