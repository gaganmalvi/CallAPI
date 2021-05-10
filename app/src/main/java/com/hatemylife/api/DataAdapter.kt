package com.hatemylife.api

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataAdapter(private var dataList: List<Model>, private val context: Context) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_home, parent, false))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Model=dataList.get(position)
        holder.titleTextView.text=Model.title
        holder.itemView.setOnClickListener() { v: View ->
            val uri: Uri? = Uri.parse(Model.url)
            val openURL = Intent(Intent.ACTION_VIEW, uri)
            context.startActivity(openURL)
        }
    }

    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        var titleTextView: TextView = itemLayoutView.findViewById(R.id.repo)
    }

}
