package com.smartdev.ejurnal.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.smartdev.ejurnal.R
import com.smartdev.ejurnal.api.ApiShowJurnal
import com.smartdev.ejurnal.data.Data
import com.smartdev.ejurnal.data.ResponseJurnalByID
import com.smartdev.ejurnal.fragment.NewsViewModel
import kotlinx.android.synthetic.main.activity_detail_jurnal.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailJurnalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_jurnal)


        Log.d("intent",(intent.getIntExtra("JurnalID", 0)).toString() )

        getDataDetailJurnal(intent.getIntExtra("JurnalID", 0))
    }

    private fun getDataDetailJurnal(id: Int?) {
        Log.d("Pindah", id.toString())
        val apiShowJurnal: ApiShowJurnal = ApiShowJurnal()
        val apiCall = id?.let { apiShowJurnal.getShowJurnalByID(it) }
        apiCall?.enqueue(object : Callback<ResponseJurnalByID>{
            override fun onResponse(
                call: Call<ResponseJurnalByID>,
                response: Response<ResponseJurnalByID>
            ) {
                response.isSuccessful.let {
                    val result = response.body()?.data
                    tv_isi_penerbit.text = result?.penerbit
                    tv_isi_judul.text = result?.judul
                    tv_isi_abstrak.text = result?.abstrak
                    tv_isi_tahun_terbit.text = result?.tahunTerbit.toString()
                    tv_isi_tanggal_update.text = result?.updatedBy

                    val list = listOf(result?.attachments)
                    val separator = "/n"

                    tv_isi_lampiran.text = list.joinToString(separator).replace("]","").replace("[","").replace(",","")
                    Log.d("resultlist123>>>",result?.penerbit.toString())
                }
            }

            override fun onFailure(call: Call<ResponseJurnalByID>, t: Throwable) {
                Log.d("FAILLLLLLL123", t.toString())
            }

        })
    }

}