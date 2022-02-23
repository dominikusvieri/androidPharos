package com.smartdev.ejurnal.fragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.smartdev.ejurnal.api.NewsApi
import com.smartdev.ejurnal.data.News
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel() {
    var result: MutableLiveData<News> = MutableLiveData()

    //to get data
    fun getResult(): LiveData<News> = result
    //==return results

    //obj//news api => getNews()
    private val newsApi:NewsApi = NewsApi()

    fun loadResult(category:String){
        val apiCall = newsApi.getNews(category)
        apiCall.enqueue(object : Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
                response.isSuccessful.let {
                    //val  resultList = response.body()?.articles//cause of Call<News> and article can be null or not
                    val resultList = News(
                        response.body()?.articles ?: emptyList()
                        //elvis operator == ternary operator (if article is null it will return empty list and article is not null it return article)
                        //to avoid NullPointerException
                    )
                    Log.d("resultlist>>>", resultList.toString())
                    result.value = resultList
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("FAILLLLLLLLLLLLLLL", t.toString() )
            }

        })
    }
}