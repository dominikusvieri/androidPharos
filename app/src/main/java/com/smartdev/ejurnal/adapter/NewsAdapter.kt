package com.smartdev.ejurnal.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smartdev.ejurnal.R
import com.smartdev.ejurnal.data.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_list_jurnal.view.*

class NewsAdapter (var articleList : List<Article> = ArrayList())
    : RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {
    inner class ArticleViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        fun bindNews(article:Article){
            //place holder is to show temp image when loading
            Picasso.get().load(article.urlToImage)
                .placeholder(R.drawable.ic_launcher_background).into(itemView.img_jurnal_photo)
            itemView.tv_list_judul.text = article.title
            itemView.tv_list_penerbit.text = article.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.card_list_jurnal, parent,false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bindNews(articleList[position])
    }

    override fun getItemCount(): Int {
        Log.d("new>>>>>",articleList.size.toString())
        return articleList.size
    }

    fun updateList(article:List<Article>){
        this.articleList = article
        notifyDataSetChanged()
    }

}