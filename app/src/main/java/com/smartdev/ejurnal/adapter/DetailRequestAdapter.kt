package com.smartdev.ejurnal.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smartdev.ejurnal.R
import com.smartdev.ejurnal.activity.DetailJurnalActivity
import com.smartdev.ejurnal.data.DataJurnal
import com.smartdev.ejurnal.data.DataRequest
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_list_jurnal.view.*

class DetailRequestAdapter (var requestList: List<DataRequest> = ArrayList())
    : RecyclerView.Adapter<DetailRequestAdapter.RequestViewHolder>(){
    private lateinit var activity : Activity

    inner class RequestViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bindArticle(article:DataRequest){
            itemView.tv_list_judul.text = article.judul
            itemView.tv_list_penerbit.text = article.penerbit
            itemView.tv_list_tahunTerbit.text = article.tahunTerbit.toString()
            Picasso.get().load(article.image).placeholder(R.drawable.jurnal_icon).into(itemView.img_jurnal_photo)

            itemView.img_jurnal_photo.setOnClickListener{
                val intent = Intent(activity, DetailJurnalActivity::class.java)
                intent.putExtra("RequestID",article.id)
                activity.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RequestViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_list_jurnal,parent,false)
        return RequestViewHolder(view)
    }

    override fun onBindViewHolder(holder: RequestViewHolder, position: Int) {
        holder.bindArticle(requestList[position])
    }

    override fun getItemCount(): Int = requestList.size

    fun updateList(article: List<DataRequest>, activity: Activity){
        this.requestList = article
        this.activity = activity
        notifyDataSetChanged()
    }
}