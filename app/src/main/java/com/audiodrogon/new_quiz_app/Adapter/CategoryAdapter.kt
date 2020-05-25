package com.audiodrogon.new_quiz_app.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.audiodrogon.new_quiz_app.Interfaces.IOnRecyclerViewItemClickListener
import com.audiodrogon.new_quiz_app.R
import com.audiodrogon.new_quiz_app.models.Category

class CategoryAdapter(internal var context: Context, internal var categoryList: List<Category>) : RecyclerView.Adapter<CategoryAdapter.myViewHolder>() {

    inner class myViewHolder(itemVew: View) : RecyclerView.ViewHolder(itemVew),
        View.OnClickListener {

        internal var txt_category_name: TextView
        internal var card_category: CardView
        internal lateinit var iOnRecyclerViewItemClickListener: IOnRecyclerViewItemClickListener

        fun setiOnRecyclerViewItemClickListener(iOnRecyclerViewItemClickListener: IOnRecyclerViewItemClickListener) {
            this.iOnRecyclerViewItemClickListener = iOnRecyclerViewItemClickListener
        }

        init {
            txt_category_name = itemVew.findViewById(R.id.txt_category_name) as TextView
            card_category = itemVew.findViewById(R.id.card_category) as CardView
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            iOnRecyclerViewItemClickListener.OnClick(view!!, adapterPosition)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.layout_category,parent,false)
        return myViewHolder(itemView )
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.txt_category_name.text = categoryList[position].name
        holder.setiOnRecyclerViewItemClickListener(object: IOnRecyclerViewItemClickListener{
            override fun OnClick(view: View, position: Int) {
                Toast.makeText(context,"${holder.txt_category_name.text}", Toast.LENGTH_SHORT).show()
            }

        })



    }
}