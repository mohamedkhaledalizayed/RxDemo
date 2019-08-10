package com.example.rxdemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.graphics.Typeface
import android.widget.Button
import android.widget.TextView




class ItemAdapter(private val context: Context) : RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var name : TextView = view.findViewById(R.id.tv_doctor_name)
        var field : TextView = view.findViewById(R.id.tv_doctor_field)
        var address : TextView = view.findViewById(R.id.tv_address)
        var phone : TextView = view.findViewById(R.id.tv_phone)
        var details : Button = view.findViewById(R.id.btn_details)

    }

    override fun getItemViewType(position: Int): Int {
        return if (position < 10){
            0
        }else{
            1
        }
    }

    private lateinit var itemView: View

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        itemView = if (viewType == 0){
//            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
//        }else{
//            LayoutInflater.from(parent.context).inflate(R.layout.fake, parent, false)
//        }

        itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val custom_font = Typeface.createFromAsset(context.assets, "fonts/font.ttf")

        holder.name.typeface = custom_font
        holder.field.typeface = custom_font
        holder.address.typeface = custom_font
        holder.phone.typeface = custom_font
        holder.details.typeface = custom_font
    }

    override fun getItemCount(): Int {
        return 25
    }
}