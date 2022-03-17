package com.smartdev.ejurnal.api

import android.util.Log
import com.google.gson.GsonBuilder
import com.smartdev.ejurnal.data.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body

class ApiShowJurnal {
    private val showJurnalInterface:InterfaceApiShowJurnal

    companion object{
        const val BASE_URL = "https://staging-api.cfu.pharmalink.id/ppds/"
    }

    init {
        val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        showJurnalInterface = retrofit.create(InterfaceApiShowJurnal::class.java)
    }

    fun getShowJurnal():Call<ResponseJurnal>{
        return showJurnalInterface.getArticle()
    }

    fun postShowJurnal(transferMethod: TransferMethod):Call<ResponsePostJurnal>{
        return showJurnalInterface.postArticle(transferMethod)
    }

    fun getShowJurnalByID(id: Int):Call<ResponseJurnalByID>{
        return showJurnalInterface.getArticleById(id)
    }

    fun getShowJurnalByUserID(user_id: Int): Call<ResponseJurnalByUserID>{
        return showJurnalInterface.getArticleByUserID(user_id)
    }

}