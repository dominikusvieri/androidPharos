package com.smartdev.ejurnal.adapter

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smartdev.ejurnal.R
import com.smartdev.ejurnal.activity.DetailJurnalActivity
import com.smartdev.ejurnal.data.DataItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_list_jurnal.view.*

class ShowArticleAdapter (var articleList:List<DataItem> = ArrayList())
    : RecyclerView.Adapter<ShowArticleAdapter.ArticleViewHolder>(){

    private lateinit var activity : Activity

    inner class ArticleViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        fun bindArticle(article:DataItem){
            itemView.tv_list_judul.text = article.judul
            itemView.tv_list_penerbit.text = article.penerbit
            itemView.tv_list_tahunTerbit.text = article.tahunTerbit.toString()
            Picasso.get().load(article.image).placeholder(R.drawable.jurnal_icon).into(itemView.img_jurnal_photo)

            itemView.img_jurnal_photo.setOnClickListener {
                Log.d("Print123","TEST123")
                val intent = Intent(activity, DetailJurnalActivity::class.java)
                Log.d("Print123Jurnal",article.id.toString())
                intent.putExtra("JurnalID",article.id)
                activity.startActivity(intent)
//                Log.d("gagal",activity.startActivity(intent).toString())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_list_jurnal,parent,false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val data = articleList[position]
        holder.bindArticle(articleList[position])
        holder.itemView.setOnClickListener {

        }
    }

    override fun getItemCount(): Int {
        Log.d("new>>>>>",articleList.size.toString())
        return articleList.size
    }

    fun updateList(article: List<DataItem> ,activity: Activity){
        this.articleList = article
        this.activity = activity
        notifyDataSetChanged()
    }

}