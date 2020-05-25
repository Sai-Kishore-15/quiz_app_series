package com.audiodrogon.new_quiz_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.audiodrogon.new_quiz_app.Adapter.CategoryAdapter
import com.audiodrogon.new_quiz_app.DBHelper.DBHelper
import com.audiodrogon.new_quiz_app.common.SpacesItemDecoration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        toolbar.title = "Test Quiz"
//        setSupportActionBar(toolbar)


        recycler_category.setHasFixedSize(true)
        recycler_category.layoutManager = GridLayoutManager(this,2)

        val adapter = CategoryAdapter(this, DBHelper.getInstance(this).allcategories)
//        recycler_category.addItemDecoration(SpacesItemDecoration(4))
        recycler_category.adapter = adapter

    }


}
