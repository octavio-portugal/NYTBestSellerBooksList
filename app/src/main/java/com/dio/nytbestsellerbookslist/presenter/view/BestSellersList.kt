package com.dio.nytbestsellerbookslist.presenter.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dio.nytbestsellerbookslist.R
import com.dio.nytbestsellerbookslist.data.ApiService
import com.dio.nytbestsellerbookslist.data.NytAPI
import com.dio.nytbestsellerbookslist.data.model.BookModel
import com.dio.nytbestsellerbookslist.data.response.BookBody
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.bookdetails_item.view.*
import kotlinx.android.synthetic.main.fragment_best_sellers_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BestSellersList : Fragment() {


    private lateinit var bestSellerAdapter:BestSellerAdapter


    private var booksLiveData: MutableLiveData<List<BookModel>> = MutableLiveData()

    companion object{
        fun newInstance(): BestSellersList{
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

        val books: MutableList<BookModel> = mutableListOf()

        bestSellerAdapter = BestSellerAdapter(books)
        rv_bestseller.adapter = bestSellerAdapter
        rv_bestseller.layoutManager = LinearLayoutManager(context)


        /** validação do adapter
        for (c in 0..7){
        val book = BookDetails()
        book.title = "Book$c"
        book.author = "Author$c"
        books.add(book)
        }
         */

        ApiService.service
            .ListBooks()
            .enqueue(object: Callback<BookBody> {
                override fun onFailure(call: Call<BookBody>, t: Throwable) {
                    Toast.makeText(context, "Error server response", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<BookBody>, response: Response<BookBody>) {
                    if(response.isSuccessful){
                        response.body()?.let { bookBody ->
                            for(result in bookBody.results){
                                val book: BookModel = BookModel(
                                    title = result.bookdetails[0].title,
                                    author = result.bookdetails[0].author,
                                )
                                books.add(book)

                            }


                            /**bestSellerAdapter.sellerlist.clear()
                            bestSellerAdapter.sellerlist.addAll(it.results)
                            bestSellerAdapter.notifyDataSetChanged()*/

                        }
                    }

                    booksLiveData.value = books
                }

            })


    }




    private inner class BestSellerAdapter(internal val sellerlist: MutableList<BookModel>): RecyclerView.Adapter<BestSellersHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellersHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.bookdetails_item, parent, false)
            return BestSellersHolder(itemView)
        }

        override fun getItemCount(): Int = sellerlist.size



        override fun onBindViewHolder(holder: BestSellersHolder, position: Int) {
            val sellersList = sellerlist[position]
            holder.bind(sellersList)
        }
    }


    private inner class BestSellersHolder (itemView: View): RecyclerView.ViewHolder(itemView) {

        private val textTitle = itemView.tv_book_title
        private val textAuthor = itemView.tv_book_author
        fun bind (body: BookModel){
            textTitle.text= body.title
            textAuthor.text = body.author
            Picasso.get().load(R.drawable.bookexemple).fit().into(itemView.iv_book_cover)

        }

    }
}


