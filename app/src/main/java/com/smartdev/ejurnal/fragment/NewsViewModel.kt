package com.smartdev.ejurnal.fragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.smartdev.ejurnal.activity.DetailJurnalActivity
import com.smartdev.ejurnal.api.ApiShowJurnal
import com.smartdev.ejurnal.data.*
import kotlinx.android.synthetic.main.activity_detail_jurnal.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel() {
    lateinit var detailJurnalActivity: DetailJurnalActivity
    var result: MutableLiveData<ResponseJurnal> = MutableLiveData()
    var resultrequest: MutableLiveData<ResponsePostJurnal> = MutableLiveData()
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

    fun loadResultbyID(id:Int){
        val apiCall = apiShowJurnal.getshowjurnalbyid(id)
        apiCall.enqueue(object : Callback<ResponseJurnalByID>{
            override fun onResponse(
                call: Call<ResponseJurnalByID>,
                response: Response<ResponseJurnalByID>
            ) {
                response.isSuccessful.let {
                    val result = response.body()?.data

                   Log.d("resultlist>>>",result?.penerbit.toString())
                }
            }

            override fun onFailure(call: Call<ResponseJurnalByID>, t: Throwable) {
                Log.d("FAILLLLLLL", t.toString())
            }

        })
    }

    fun postresult(transferMethod:TransferMethod){
        val apiCall = apiShowJurnal.postShowJurnal(transferMethod)
        apiCall.enqueue(object : Callback<ResponsePostJurnal>{
            override fun onResponse(
                call: Call<ResponsePostJurnal>,
                response: Response<ResponsePostJurnal>
            ) {
                response.isSuccessful.let {
                    val resultList = ResponsePostJurnal(
                        response.body()?.data ?: emptyList()
                    )
                    Log.d("resultlist>>>",response.body().toString())
                    resultrequest.value = resultList
                }
            }

            override fun onFailure(call: Call<ResponsePostJurnal>, t: Throwable) {
                Log.d("FAILLLLLLL", t.toString())
            }

        })
    }

}

