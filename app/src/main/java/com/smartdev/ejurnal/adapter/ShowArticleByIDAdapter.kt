package com.smartdev.ejurnal.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smartdev.ejurnal.R
import com.smartdev.ejurnal.activity.DetailJurnalActivity
import com.smartdev.ejurnal.activity.DetailJurnalByIdActivity
import com.smartdev.ejurnal.data.DataItem
import com.smartdev.ejurnal.data.DataJurnal
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_list_jurnal.view.*
import kotlinx.android.synthetic.main.card_list_jurnal.view.img_jurnal_photo
import kotlinx.android.synthetic.main.card_list_jurnal_byid.view.*

class ShowArticleByUserIDAdapter (var articleList:List<DataJurnal> = ArrayList())
    : RecyclerView.Adapter<ShowArticleByUserIDAdapter.ArticleByIDViewHolder>() {

    private lateinit var activity : Activity
    inner class ArticleByIDViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        fun bindArticleByID(article : DataJurnal){
            itemView.tv_topik.text = article.topik
            val dateUpdate = (article.lastUpdate).toString()
            itemView.tv_tanggal_update.text = dateUpdate.replace("T", "      ").replace("+07:00", "")
            Picasso.get().load(article.image).placeholder(R.drawable.jurnal_icon).into(itemView.img_jurnal_photo)
            itemView.img_jurnal_photo.setOnClickListener {
                val intent = Intent(activity, DetailJurnalByIdActivity::class.java)
                intent.putExtra("JurnalID",article.id)
                activity.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleByIDViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_list_jurnal_byid,parent,false)
        return ArticleByIDViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleByIDViewHolder, position: Int) {
        holder.bindArticleByID(articleList[position])
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    fun updateList(article: List<DataJurnal> ,activity: Activity){
        this.articleList = article
        this.activity = activity
        notifyDataSetChanged()
    }

}