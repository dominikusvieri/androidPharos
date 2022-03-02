package com.smartdev.ejurnal.api

import com.smartdev.ejurnal.data.ResponseJurnal
import com.smartdev.ejurnal.data.ResponsePostJurnal
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body

class ApiShowJurnal {
    private val showJurnalInterface:InterfaceApiShowJurnal

    companion object{
        const val BASE_URL = "http://10.0.111.64:8080/ppds/"
    }

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        showJurnalInterface = retrofit.create(InterfaceApiShowJurnal::class.java)
    }

    fun getShowJurnal():Call<ResponseJurnal>{
        return showJurnalInterface.getArticle()
    }

    fun postShowJurnal(topik:String, deskripsi:String):Call<ResponsePostJurnal>{
        return showJurnalInterface.postArticle("")
    }

}