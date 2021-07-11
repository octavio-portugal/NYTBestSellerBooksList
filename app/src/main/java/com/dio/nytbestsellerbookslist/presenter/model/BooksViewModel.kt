package com.dio.nytbestsellerbookslist.presenter.model

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dio.nytbestsellerbookslist.data.ApiService
import com.dio.nytbestsellerbookslist.data.model.BookModel
import com.dio.nytbestsellerbookslist.data.response.BookBody
import com.dio.nytbestsellerbookslist.presenter.view.BestSellersList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
/**
class BooksViewModel : ViewModel() {

    val booksLiveData: MutableLiveData<List<BookModel>> = MutableLiveData()

    fun getBooks(){
        ApiService.service.ListBooks().enqueue(object : Callback<BookBody> {


            override fun onResponse(call: Call<BookBody>, response: Response<BookBody>) {
                if (response.isSuccessful) {
                    val books: MutableList<BookModel> = mutableListOf()

                    response.body()?.let { bookBody ->
                        for (result in bookBody.results) {
                            val book: BookModel = BookModel(
                                title = result.bookdetails[0].title,
                                author = result.bookdetails[0].author,
                            )
                            books.add(book)

                        }
                    }
                    booksLiveData.value = books
                }
            }

            override fun onFailure(call: Call<BookBody>, t: Throwable) {
               // Toast.makeText(BestSellersList, "Error server response", Toast.LENGTH_SHORT).show()
            }
        })

    }

}
        */
