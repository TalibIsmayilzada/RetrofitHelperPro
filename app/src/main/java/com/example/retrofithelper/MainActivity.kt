package com.example.retrofithelper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.retrofit_helper.utils.RetrofitHelper
import com.example.retrofit_helper.utils.hide

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView : TextView = findViewById(R.id.textView)

        textView.hide()

        val api: API = RetrofitHelper.setupRetrofit<API>(30,"hhtps://cbar.az")

    }
}