package com.dio.nytbestsellerbookslist.presenter.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.dio.nytbestsellerbookslist.R
import com.dio.nytbestsellerbookslist.data.ApiInterface
import com.dio.nytbestsellerbookslist.data.model.BookModel
import com.dio.nytbestsellerbookslist.data.response.BookBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TesteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teste)



        var book: BookBody? = null

        val apiInterface = ApiInterface.iniciaRetrofit()?.getBooks()

        apiInterface?.enqueue(object: Callback<BookBody> {
            override fun onResponse(call: Call<BookBody>, response: Response<BookBody>) {
                if (book != null) {
                    response.body()
                    Toast.makeText(this@TesteActivity, "RESPONDEU", Toast.LENGTH_SHORT).show()
                    Log.w("RESPONDEU", "RESPONDEU" )
                }
            }

            override fun onFailure(call: Call<BookBody>, t: Throwable) {
                Toast.makeText(this@TesteActivity, "error", Toast.LENGTH_SHORT).show()
                Log.w("ERRO", "FALHOU")
            }

        })
    }
}