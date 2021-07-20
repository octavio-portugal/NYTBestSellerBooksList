package com.dio.nytbestsellerbookslist.presenter.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.dio.nytbestsellerbookslist.R
import androidx.recyclerview.widget.RecyclerView
import com.dio.nytbestsellerbookslist.data.ApiInterface
import com.dio.nytbestsellerbookslist.data.model.BookModel
import com.dio.nytbestsellerbookslist.data.response.BookBody
import com.dio.nytbestsellerbookslist.presenter.model.BooksAdapter
import kotlinx.android.synthetic.main.bookdetails_item.view.*
import kotlinx.android.synthetic.main.fragment_best_sellers_list.*
import kotlinx.android.synthetic.main.fragment_best_sellers_list.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BestSellersList : Fragment() {


    // private lateinit var bestSellerAdapter:BestSellerAdapter
    private lateinit var booksAdapter: BooksAdapter


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

        val books = listOf<BookModel>()
        val booksAdapter = BooksAdapter(books)
        rv_bestseller.adapter = booksAdapter
        rv_bestseller.layoutManager = LinearLayoutManager(context)




        var book: MutableList<BookModel> = mutableListOf<BookModel>()

        val apiInterface = ApiInterface.iniciaRetrofit()?.getBooks()

        apiInterface?.enqueue(object: Callback<BookBody> {
            override fun onResponse(call: Call<BookBody>, response: Response<BookBody>) {
                if (book != null) {
                    response.body()?.let { bookBody ->
                        for (resultado in bookBody.results){
                            val livro: BookModel = BookModel(
                                title = resultado.bookdetails[0].title,
                                author = resultado.bookdetails[0].author
                            )
                            book.add(livro)
                        }

                    }
                    Toast.makeText(context, "RESPONDEU", Toast.LENGTH_SHORT).show()
                    Log.i("RESPONDEU", "RESPONDEU" )
                }
            }

            override fun onFailure(call: Call<BookBody>, t: Throwable) {
                if (book != null){
                    Toast.makeText(context, "error", Toast.LENGTH_SHORT).show()
                    Log.i("ERRO", "FALHOU")
                }

            }

        })
    }

}






    /**
    val books: MutableList<BookModel> = mutableListOf()


    bestSellerAdapter = BestSellerAdapter(books)
    rv_bestseller.adapter = bestSellerAdapter
    rv_bestseller.layoutManager = LinearLayoutManager(context)


    // validação do adapter
    for (c in 0..7){
    val book = BookDetails()
    book.title = "Book$c"
    book.author = "Author$c"
    books.add(book)
    }


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


    bestSellerAdapter.sellerlist.clear()
    bestSellerAdapter.sellerlist.addAll(it.results)
    bestSellerAdapter.notifyDataSetChanged()

    }
    }

    booksLiveData.value = books
    }

    })



    // getTextsTest()

}

/**fun getTextsTest(body: BookModel):BookModel {
val testTitle = tv_book_test_title
val testAuthor = tv_book_test_title
testTitle.text = body.title
testAuthor.text = body.author
}
 */

/**
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

private val textTitle = itemView.tv_book_test_title
private val textAuthor = itemView.tv_book_test_author
fun bind (body: BookModel){
textTitle.text= body.title
textAuthor.text = body.author
// Picasso.get().load(R.drawable.bookexemple).fit().into(itemView.iv_book_cover)

}

}
}
 */