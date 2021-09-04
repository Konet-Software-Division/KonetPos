package com.konet.konetpos.ui.screen.billerlist

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.konet.konetpos.R
import com.konet.konetpos.network.response.BillerListResponse

class BillerListAdapter(var context: Context?, arrayList: ArrayList<BillerListResponse>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var list = arrayList
    var originalList: ArrayList<BillerListResponse> = ArrayList()

    class TransactionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val billerTv: TextView = view.findViewById(R.id.biller)
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): TransactionViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_billerlist, parent, false)

        context = itemView.context
        return TransactionViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setOriginalList(data: List<BillerListResponse>?) {
        originalList = data as ArrayList<BillerListResponse>
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as TransactionViewHolder
        if (itemCount > 0) {

            holder.billerTv.text = list[position].wallet.name
        }
    }

}