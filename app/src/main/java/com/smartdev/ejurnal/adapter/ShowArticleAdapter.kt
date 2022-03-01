package com.smartdev.ejurnal.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smartdev.ejurnal.R
import com.smartdev.ejurnal.data.DataItem
import kotlinx.android.synthetic.main.card_list_jurnal.view.*

class ShowArticleAdapter (var articleList:List<DataItem> = ArrayList())
    : RecyclerView.Adapter<ShowArticleAdapter.ArticleViewHolder>(){
    inner class ArticleViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        fun bindArticle(article:DataItem){
            itemView.tv_list_judul.text = article.judul
            itemView.tv_list_penerbit.text = article.penerbit
            itemView.tv_list_tahunTerbit.text = article.tahunTerbit.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_list_jurnal,parent,false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bindArticle(articleList[position])
    }

    override fun getItemCount(): Int {
        Log.d("new>>>>>",articleList.size.toString())
        return articleList.size
    }

    fun updateList(article: List<DataItem>){
        this.articleList = article
        notifyDataSetChanged()
    }

}