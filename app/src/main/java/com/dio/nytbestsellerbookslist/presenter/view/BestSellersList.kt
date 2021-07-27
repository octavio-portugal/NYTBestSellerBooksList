package com.dio.nytbestsellerbookslist.presenter.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dio.nytbestsellerbookslist.R
import androidx.recyclerview.widget.RecyclerView
import com.dio.nytbestsellerbookslist.data.model.BookModel
import com.dio.nytbestsellerbookslist.data.response.BookBody
import com.dio.nytbestsellerbookslist.data.response.BookInformations
import com.dio.nytbestsellerbookslist.presenter.model.BooksAdapter
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.bookdetails_item.*
import kotlinx.android.synthetic.main.bookdetails_item.view.*
import kotlinx.android.synthetic.main.fragment_best_sellers_list.*
import kotlinx.android.synthetic.main.fragment_best_sellers_list.view.*


class BestSellersList : Fragment() {


    // private lateinit var bestSellerAdapter:BestSellerAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: BooksAdapter

    //private var booksLiveData: MutableLiveData<List<BookModel>> = MutableLiveData()

    companion object {
        fun newInstance(): BestSellersList {
            val fragmentBestList = BestSellersList()
            val arguments = Bundle()
            fragmentBestList.arguments = arguments
            return fragmentBestList
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_best_sellers_list, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {



    }

}






