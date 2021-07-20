package com.dio.nytbestsellerbookslist.presenter.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.dio.nytbestsellerbookslist.R
import com.dio.nytbestsellerbookslist.data.ApiInterface
import com.dio.nytbestsellerbookslist.data.response.BookBody
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BaseActivity : AppCompatActivity() {

    private var Content: FrameLayout? = null

    private var mOnItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId){

            R.id.nav_list -> {
                val fragment = BestSellersList.newInstance()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }

            R.id.nav_wish -> {
                val fragment = WishList.newInstance()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Content = content
        bottom_menu.setOnNavigationItemSelectedListener(mOnItemSelectedListener)


    }

    private fun addFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content, fragment, fragment.javaClass.simpleName)
            .commit()
    }
}