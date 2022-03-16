package com.smartdev.ejurnal.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smartdev.ejurnal.R
import com.smartdev.ejurnal.adapter.ShowArticleByUserIDAdapter
import com.smartdev.ejurnal.api.ApiShowJurnal
import com.smartdev.ejurnal.data.DataJurnal
import com.smartdev.ejurnal.data.ResponseJurnalByUserID
import kotlinx.android.synthetic.main.fragment_list_request.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListRequestFragment : Fragment() {
    private lateinit var showArticleByIDAdapter: ShowArticleByUserIDAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_request, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getRequestData(424)
        viewManager = LinearLayoutManager(activity)
        showArticleByIDAdapter = ShowArticleByUserIDAdapter()
        rv_jurnal.apply {
            adapter = showArticleByIDAdapter
            layoutManager = viewManager
//            getRequestData(424)
        }
    }



    fun getRequestData(user_id: Int){
        val apiShowJurnal: ApiShowJurnal = ApiShowJurnal()
        val apiCall = user_id?.let { apiShowJurnal.getShowJurnalByUserID(424) }
        apiCall.enqueue(object : Callback<ResponseJurnalByUserID>{
            override fun onResponse(
                call: Call<ResponseJurnalByUserID>,
                response: Response<ResponseJurnalByUserID>
            ) {
                activity?.let {
                    showArticleByIDAdapter.updateList(response.body()?.dataReqId as List<DataJurnal>,
                        it
                    )
                }
                Log.d("SuccessGGG", call.request().url().toString())
                Log.d("Successbgt", (response.body()?.dataReqId?.get(0)?.topik).toString())
            }

            override fun onFailure(call: Call<ResponseJurnalByUserID>, t: Throwable) {
                Log.d("FAILLLLLLL123", t.toString())
            }

        })
    }


}