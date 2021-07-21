package com.dio.nytbestsellerbookslist.presenter.model

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dio.nytbestsellerbookslist.data.ApiInterface
import com.dio.nytbestsellerbookslist.data.model.BookModel
import com.dio.nytbestsellerbookslist.data.response.BookBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel: ViewModel() {

    val booksLiveData : MutableLiveData<List<BookModel>> = MutableLiveData()

    fun getBooks(){
        //booksLiveData.value = createFakeBooks()
        ApiInterface.iniciaRetrofit()?.getBooks()?.enqueue(object: Callback<BookBody>{
            override fun onResponse(call: Call<BookBody>, response: Response<BookBody>) {
                if(response.isSuccessful){
                    val books: MutableList<BookModel> = mutableListOf()

                    response.body()?.let {bookBodyResponse ->
                        for (result in bookBodyResponse.results){
                            val book: BookModel = BookModel(
                                title = result.bookdetails[0].titulo,
                                author = result.bookdetails[0].autor,
                            )

                            books.add(book)
                        }
                    }

                    booksLiveData.value = books
                }
                Log.i("RESPONDEU", "RESPONDEU")
            }

            override fun onFailure(call: Call<BookBody>, t: Throwable) {
                Log.i("ERRO", "FALHOU")

            }

        })
    }
}