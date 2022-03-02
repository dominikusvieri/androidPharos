package com.smartdev.ejurnal.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.smartdev.ejurnal.R
import com.smartdev.ejurnal.api.ApiShowJurnal
import com.smartdev.ejurnal.data.ResponseJurnal
import com.smartdev.ejurnal.data.ResponsePostJurnal
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_request_jurnal.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RequestJurnalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_jurnal)
        topik = etJudulJurnal.text.toString()
        btnRequest.setOnClickListener {
            postJurnal()
        }
        deskripsi = etDeskripsiJurnal.text.toString()

    }

    var result: MutableLiveData<ResponsePostJurnal> = MutableLiveData()
    lateinit var topik: String
    lateinit var deskripsi: String
    private val apiShowJurnal: ApiShowJurnal = ApiShowJurnal()
    private fun postJurnal() {
        val apiCall = apiShowJurnal.postShowJurnal(topik, deskripsi)
        apiCall.enqueue(object : Callback<ResponsePostJurnal> {
            override fun onResponse(
                call: Call<ResponsePostJurnal>,
                response: Response<ResponsePostJurnal>
            ) {
                response.isSuccessful.let {
                    val resultList = ResponsePostJurnal(
                        response.body()?.data ?: emptyList()
                    )
                    Log.d("resultlist>>>", resultList.toString())
                    result.value = resultList
                }
            }

            override fun onFailure(call: Call<ResponsePostJurnal>, t: Throwable) {
                Log.d("FAILLLLLLL", t.toString())
            }

        })
    }

}