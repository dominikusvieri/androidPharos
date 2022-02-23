package com.smartdev.ejurnal.api

import com.smartdev.ejurnal.data.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsApi {
    private val newsApiInterface:NewsApiInterface

    companion object{
        const val BASE_URL = "https://newsapi.org/v2/" //can call with direct class name
    }

    //when create class obj and it create retrofits
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsApiInterface = retrofit.create(NewsApiInterface::class.java)
    }

    fun getNews(category:String): Call<News>{
        return newsApiInterface.getNews(category)
    }
}