package com.smartdev.ejurnal.fragment

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smartdev.ejurnal.R
import com.smartdev.ejurnal.adapter.ShowArticleAdapter
import com.smartdev.ejurnal.api.ApiShowJurnal
import com.smartdev.ejurnal.data.*
import kotlinx.android.synthetic.main.fragment_list_jurnal.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ListJurnalFragment : Fragment() {

    private lateinit var showArticleAdapter: ShowArticleAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var newsViewModel: NewsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_jurnal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewManager = LinearLayoutManager(activity)

        //no need to add constructor cause of we defined array list
        showArticleAdapter = ShowArticleAdapter()
        rv_jurnal.apply {
            adapter = showArticleAdapter
            layoutManager = viewManager
            observeViewModel()
        }

        sv_jurnal.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { getArticleByJudul(it) }
                return false
            }

            override fun onQueryTextChange(textJudul: String?): Boolean {
                if (TextUtils.isEmpty(textJudul)){
                    textJudul?.let { getArticleByJudul(it) }
                }
                return false
            }

        })


    }

    fun getArticleByJudul(judul: String){
        Log.d("Judul", judul)
        ApiShowJurnal().getShowSearchJurnal(judul).enqueue(object : Callback<ResponseJurnal>{
            override fun onResponse(
                call: Call<ResponseJurnal>,
                response: Response<ResponseJurnal>
            ) {
                activity?.let { showArticleAdapter.updateList(response.body()!!.data as List<DataItem>, it) }
            }

            override fun onFailure(call: Call<ResponseJurnal>, t: Throwable) {
                Toast.makeText(activity, "Judul", Toast.LENGTH_SHORT).show()
            }

        })
    }

    //to get data from VM
    fun observeViewModel() {
        //create VM object
        newsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)

        newsViewModel.getResult().observe(
            viewLifecycleOwner, Observer { result ->
                activity?.let { showArticleAdapter.updateList(result.data as List<DataItem>, it) }//to add data //result is News()
                //result == newsViewModel.getResults() data
            }
        )
    }

    override fun onResume() {
        //to get result
        super.onResume()
        newsViewModel.`loadResult`()//data loading and get data
//        newsViewModel.postresult(transferMethod = TransferMethod("",(activity as JurnalMainActivity).tvJudul.text.toString(),(activity as JurnalMainActivity).tvDesc.text.toString()))
//        Log.i("testing",TransferMethod("",(activity as JurnalMainActivity).tvJudul.text.toString(),(activity as JurnalMainActivity).tvDesc.text.toString()).toString())
    }



}


