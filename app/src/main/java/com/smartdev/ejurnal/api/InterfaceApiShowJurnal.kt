package com.smartdev.ejurnal.api

import com.smartdev.ejurnal.data.ResponseJurnal
import com.smartdev.ejurnal.data.ResponseJurnalByID
import com.smartdev.ejurnal.data.ResponsePostJurnal
import com.smartdev.ejurnal.data.TransferMethod
import retrofit2.Call
import retrofit2.http.*

interface InterfaceApiShowJurnal {

    @GET("articles")
    fun getArticle():Call<ResponseJurnal>

    @GET("articles?")
    fun getArticleById(
        @Query("id")id: Int
    ): Call<ResponseJurnalByID>

    @POST("requests")
    fun postArticle(
        @Body transferMethod: TransferMethod
    ):Call<ResponsePostJurnal>
}