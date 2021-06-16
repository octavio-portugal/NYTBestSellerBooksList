package com.dio.nytbestsellerbookslist.presenter.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dio.nytbestsellerbookslist.R
import com.dio.nytbestsellerbookslist.data.response.BookBody
import com.dio.nytbestsellerbookslist.data.response.BookDetails
import kotlinx.android.synthetic.main.bookdetails_item.*
import kotlinx.android.synthetic.main.bookdetails_item.view.*
import kotlinx.android.synthetic.main.bookdetails_item.view.iv_book_cover
import kotlinx.android.synthetic.main.fragment_best_sellers_list.*


class BestSellersList : Fragment() {


    private lateinit var bestSelleeAdapter:BestSellerAdapter


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

        val books: MutableList<BookDetails> = ArrayList()
        for (c in 0..7){
            val book = BookDetails()
            book.title = "Book$c"
            book.author = "Author$c"
            books.add(book)
        }


        //val body = arrayListOf<BookBody>()
        bestSelleeAdapter = BestSellerAdapter(books)
        rv_bestseller.adapter = bestSelleeAdapter
        rv_bestseller.layoutManager = LinearLayoutManager(context)


        /**retrotif().create(NytAPI::class.java)
            .ListBooks()
            .enqueue(object: Callback<BookBody>{
                override fun onFailure(call: Call<BookBody>, t: Throwable) {
                    Toast.makeText(context, "Error server response", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<BookBody>, response: Response<BookBody>) {
                    if(response.isSuccessful){
                        response.body()?.let {

                        }
                    }

                }

            })*/


    }




    private inner class BestSellerAdapter(internal val sellerlist: MutableList<BookDetails>):
        RecyclerView.Adapter<BestSellersHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellersHolder {
            return BestSellersHolder(LayoutInflater.from(parent.context).inflate(R.layout.bookdetails_item, parent, false))
        }

        override fun getItemCount(): Int = sellerlist.size



        override fun onBindViewHolder(holder: BestSellersHolder, position: Int) {
            val sellersList = sellerlist[position]
            holder.bind(sellersList)
        }
    }


    private inner class BestSellersHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind (body: BookDetails){
            itemView.tv_book_title.text = body.title
            itemView.tv_book_author.text = body.author
            iv_book_cover.clipToOutline(true)
        }


    }
}

private fun ImageView.clipToOutline(value: Boolean) {
    iv_book_cover.clipToOutline

}
