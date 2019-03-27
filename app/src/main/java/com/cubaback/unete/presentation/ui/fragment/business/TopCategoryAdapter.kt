package com.cubaback.unete.presentation.ui.fragment.business

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cubaback.unete.R
import com.cubaback.unete.presentation.model.CategoryView
import kotlinx.android.synthetic.main.item_top_category.view.*

class TopCategoryAdapter(private val mListener : BusinessFragment.BusinessFragmentCallback,
                         private val context: Context) : RecyclerView.Adapter<TopCategoryAdapter.CategoryViewHolder>(){



    private val mOnClickListener : View.OnClickListener

    var mCategories : List<CategoryView> ? = null
    set(value){
        field = value
        notifyDataSetChanged()
    }

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as CategoryView
            mListener.onCategoryClick(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_top_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        if(mCategories != null){
            return mCategories?.size!!
        }
        return 0
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        mCategories?.apply {
            val cat = this[position]
            holder.btnCatTitle.text = cat.name
            with(holder.mView){
                tag = cat
                setOnClickListener (mOnClickListener )
            }
         }
    }

    inner class CategoryViewHolder (val mView : View) : RecyclerView.ViewHolder(mView){
        val btnCatTitle : TextView = mView.btnCatTitle
    }
}
