package com.smartdev.ejurnal.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smartdev.ejurnal.R
import com.smartdev.ejurnal.adapter.ShowArticleAdapter
import com.smartdev.ejurnal.data.DataItem
import kotlinx.android.synthetic.main.fragment_list_jurnal.*


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
    }

    //to get data from VM
    fun observeViewModel() {
        //create VM object
        newsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)

        newsViewModel.getResult().observe(
            viewLifecycleOwner, Observer { result ->
                showArticleAdapter.updateList(result.data as List<DataItem>)//to add data //result is News()
                //result == newsViewModel.getResults() data
            }
        )
    }

    override fun onResume() {
        //to get result
        super.onResume()
        newsViewModel.loadResult()//data loading and get data
    }
}