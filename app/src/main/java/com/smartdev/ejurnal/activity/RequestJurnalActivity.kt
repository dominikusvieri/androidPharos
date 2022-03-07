package com.smartdev.ejurnal.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import com.smartdev.ejurnal.R
import com.smartdev.ejurnal.api.ApiShowJurnal
import com.smartdev.ejurnal.data.ResponseJurnal
import com.smartdev.ejurnal.data.ResponsePostJurnal
import com.smartdev.ejurnal.data.TransferMethod
import com.smartdev.ejurnal.fragment.ListRequestFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_request_jurnal.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RequestJurnalActivity : AppCompatActivity() {
    private lateinit var etJudul: EditText
    private lateinit var etDesc: EditText
    private lateinit var btnRequest: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_jurnal)
        etJudul = findViewById(R.id.etJudulJurnal)
        etDesc = findViewById(R.id.etDeskripsiJurnal)
        btnRequest = findViewById(R.id.btnRequest)

        btnRequest.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("judul", etJudul.text.toString())
            bundle.putString("desc", etDesc.text.toString())

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }


//        topik = etJudulJurnal.text.toString()
//        btnRequest.setOnClickListener {
//            postJurnal()
//        }


    }

//    var result: MutableLiveData<ResponsePostJurnal> = MutableLiveData()
//    lateinit var topik: String
//    lateinit var deskripsi: String
//    private val apiShowJurnal: ApiShowJurnal = ApiShowJurnal()
//    lateinit var transferMethod:TransferMethod


//    private fun postJurnal() {
//        val apiCall = apiShowJurnal.postShowJurnal(transferMethod)
//        apiCall.enqueue(object : Callback<ResponsePostJurnal> {
//            override fun onResponse(
//                call: Call<ResponsePostJurnal>,
//                response: Response<ResponsePostJurnal>
//            ) {
//                response.isSuccessful.let {
//                    val resultList = ResponsePostJurnal(
//                        response.body()?.data ?: emptyList()
//                    )
//                    Log.d("resultlist>>>", resultList.toString())
//                    result.value = resultList
//                }
//            }
//
//            override fun onFailure(call: Call<ResponsePostJurnal>, t: Throwable) {
//                Log.d("FAILLLLLLL", t.toString())
//            }
//
//        })
//    }

}