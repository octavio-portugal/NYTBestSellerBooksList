package com.dio.nytbestsellerbookslist.presenter.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dio.nytbestsellerbookslist.R


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

}