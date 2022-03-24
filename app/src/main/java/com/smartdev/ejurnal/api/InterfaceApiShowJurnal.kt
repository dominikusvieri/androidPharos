package com.smartdev.ejurnal.api

import com.smartdev.ejurnal.data.*
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

    @GET("requests?")
    fun getArticleByUserID(
        @Query("userID")user_id:Int
    ):Call<ResponseJurnalByUserID>

    @GET("articles?")
    fun getJudulArticle(
        @Query("judul") judul: String
    ):Call<ResponseJurnal>
}