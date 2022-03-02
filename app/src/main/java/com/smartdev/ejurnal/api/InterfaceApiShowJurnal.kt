package com.smartdev.ejurnal.api

import com.smartdev.ejurnal.data.ResponseJurnal
import com.smartdev.ejurnal.data.ResponsePostJurnal
import com.smartdev.ejurnal.data.TransferMethod
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

interface InterfaceApiShowJurnal {

    @GET("articles")
    fun getArticle():Call<ResponseJurnal>

    @POST("requests")
    fun postArticle(
        @Body transferMethod: TransferMethod
    ):Call<ResponsePostJurnal>
}