package com.dio.nytbestsellerbookslist.presenter.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.dio.nytbestsellerbookslist.R
import com.dio.nytbestsellerbookslist.data.ApiInterface
import com.dio.nytbestsellerbookslist.data.response.BookBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class WishList : Fragment() {


    companion object{
        fun newInstance() : WishList{
            val fragmentWish = WishList()
            val arguments = Bundle()
            fragmentWish.arguments = arguments
            return fragmentWish
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wish_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var book: BookBody

        val apiInterface = ApiInterface.iniciaRetrofit()?.getBooks()

        apiInterface?.enqueue(object: Callback<BookBody> {
            override fun onResponse(call: Call<BookBody>, response: Response<BookBody>) {
                response.body()
                Log.i("RESPONDEU", "" )
            }

            override fun onFailure(call: Call<BookBody>, t: Throwable) {
                return Toast.makeText(context, "error", Toast.LENGTH_LONG).show()
            }

        })


    }

}