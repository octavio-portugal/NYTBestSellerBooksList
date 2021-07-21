package com.dio.nytbestsellerbookslist.presenter.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dio.nytbestsellerbookslist.R
import com.dio.nytbestsellerbookslist.data.response.BookInformations
import kotlinx.android.synthetic.main.bookdetails_item.view.*

class BooksAdapter(var books: MutableList<BookInformations>): RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.bookdetails_item, parent, false)
        return BooksViewHolder(view)
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.bind(books[position])
    }

    override fun getItemCount(): Int = books.size


    class BooksViewHolder(view : View): RecyclerView.ViewHolder(view) {
        var titulo = itemView.tv_book_title
        var autor = itemView.tv_book_author

        fun bind(book: BookInformations){
            titulo.text = book.titulo
            autor.text = book.autor
        }

    }
}
