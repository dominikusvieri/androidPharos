package com.smartdev.ejurnal.fragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.smartdev.ejurnal.api.ApiShowJurnal
import com.smartdev.ejurnal.data.ResponseJurnal
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel() {
    var result: MutableLiveData<ResponseJurnal> = MutableLiveData()

    fun getResult(): LiveData<ResponseJurnal> = result

    private val apiShowJurnal: ApiShowJurnal = ApiShowJurnal()

    fun loadResult(){
        val apiCall = apiShowJurnal.getShowJurnal()
        apiCall.enqueue(object : Callback<ResponseJurnal>{
            override fun onResponse(
                call: Call<ResponseJurnal>,
                response: Response<ResponseJurnal>
            ) {
                response.isSuccessful.let {
                    val resultList = ResponseJurnal(
                        response.body()?.data ?: emptyList()
                    )
                    Log.d("resultlist>>>",resultList.toString())
                    result.value = resultList
                }
            }

            override fun onFailure(call: Call<ResponseJurnal>, t: Throwable) {
                Log.d("FAILLLLLLL", t.toString())
            }

        })
    }
}