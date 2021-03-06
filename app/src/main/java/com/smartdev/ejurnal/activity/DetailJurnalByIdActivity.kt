package com.smartdev.ejurnal.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smartdev.ejurnal.R
import com.smartdev.ejurnal.adapter.DetailRequestAdapter
import com.smartdev.ejurnal.api.ApiShowJurnal
import com.smartdev.ejurnal.data.DataRequest
import com.smartdev.ejurnal.data.ResponseRequestById
import kotlinx.android.synthetic.main.activity_detail_jurnal_by_id.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailJurnalByIdActivity : AppCompatActivity() {
    private lateinit var detailRequestAdapter: DetailRequestAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_jurnal_by_id)

        iv_back.setOnClickListener{
            val intent = Intent(this, JurnalMainActivity::class.java)
            startActivity(intent)
        }

        tv_topik.text = intent.getStringExtra("Topik")
        tv_desc.text = intent.getStringExtra("Deskripsi")

        Log.d("IDREQ", (intent.getIntExtra("RequestID", 0)).toString())
        Log.d("TopikIntent", intent.getStringExtra("Topik").toString())

        getDetailRequest(intent.getIntExtra("RequestID", 0))
        viewManager = LinearLayoutManager(this)
        detailRequestAdapter = DetailRequestAdapter()
        rv_detailRequest.apply {
            adapter = detailRequestAdapter
            layoutManager = viewManager
        }
    }



    private fun getDetailRequest(request_id: Int) {
        val apiShowJurnal: ApiShowJurnal = ApiShowJurnal()
        val apiCall = request_id.let { apiShowJurnal.getDetailRequestJurnal(it) }
        apiCall.enqueue(object : Callback<ResponseRequestById>{
            override fun onResponse(
                call: Call<ResponseRequestById>,
                response: Response<ResponseRequestById>
            ) {
                response.isSuccessful.let {
                    if (response.body()?.dataRequest?.size == 0){
                        Log.d("Gone", "abc")
                        tv_none.visibility = View.VISIBLE
                    }else{
                        detailRequestAdapter.updateList(response.body()?.dataRequest as List<DataRequest>, activity = this@DetailJurnalByIdActivity)
                    }
//                    detailRequestAdapter.updateList(response.body()?.dataRequest as List<DataRequest>, activity = this@DetailJurnalByIdActivity)

                }

            }

            override fun onFailure(call: Call<ResponseRequestById>, t: Throwable) {
                Log.d("FAILLLLLLL456", t.toString())
            }

        })
    }
}