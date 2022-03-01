package com.smartdev.ejurnal.api

import com.smartdev.ejurnal.data.ResponseJurnal
import retrofit2.Call
import retrofit2.http.GET

interface InterfaceApiShowJurnal {

    @GET("articles")
    fun getArticle():Call<ResponseJurnal>
}