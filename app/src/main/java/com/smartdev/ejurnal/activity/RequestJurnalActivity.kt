package com.smartdev.ejurnal.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.smartdev.ejurnal.R
import com.smartdev.ejurnal.api.ApiShowJurnal
import com.smartdev.ejurnal.data.ResponsePostJurnal
import com.smartdev.ejurnal.data.TransferMethod
import kotlinx.android.synthetic.main.activity_request_jurnal.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RequestJurnalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_jurnal)

        btnRequest.setOnClickListener {
            val judulJurnal = etJudulJurnal.text.toString()
            val deskripsiJurnal = etDeskripsiJurnal.text.toString()

            if (TextUtils.isEmpty(judulJurnal)){
                Toast.makeText(applicationContext,"Isi Judul", Toast.LENGTH_LONG).show()
            } else if (TextUtils.isEmpty(deskripsiJurnal)){
                Toast.makeText(applicationContext,"Isi Deskripsi", Toast.LENGTH_LONG).show()
            } else if (!TextUtils.isEmpty(judulJurnal)&&!TextUtils.isEmpty(deskripsiJurnal)){
                postresult(transferMethod = TransferMethod("424",etDeskripsiJurnal.text.toString(),etJudulJurnal.text.toString()))
            }
        }
    }

    fun postresult(transferMethod: TransferMethod){
        val apiShowJurnal: ApiShowJurnal = ApiShowJurnal()
        val apiCall = apiShowJurnal.postShowJurnal(transferMethod)
        apiCall.enqueue(object : Callback<ResponsePostJurnal>{
            override fun onResponse(
                call: Call<ResponsePostJurnal>,
                response: Response<ResponsePostJurnal>
            ) {
                response.isSuccessful.let {
                    if (it){
                        val intent = Intent(this@RequestJurnalActivity, JurnalMainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(applicationContext, "Hello Dunia", Toast.LENGTH_LONG).show()
                    }
                }
            }

            override fun onFailure(call: Call<ResponsePostJurnal>, t: Throwable) {
                Log.d("FAILLLLLLL", t.toString())

                Toast.makeText(applicationContext, "Gagal", Toast.LENGTH_LONG).show()
            }

    })
    }
}