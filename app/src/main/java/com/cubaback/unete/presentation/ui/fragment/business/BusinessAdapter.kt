package com.cubaback.unete.presentation.ui.fragment.business

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.GenericTransitionOptions
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cubaback.unete.R
import com.cubaback.unete.presentation.model.BusinessDataView
import kotlinx.android.synthetic.main.fragment_business.view.*


class BusinessAdapter(
        private val mListener: BusinessFragment.BusinessFragmentCallback?,
        private val context : Context)
    : RecyclerView.Adapter<BusinessAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener
    val glideOptions = RequestOptions()

    var mValues: List<BusinessDataView>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

   init {
        glideOptions.placeholder(R.drawable.s1)
        glideOptions.error(R.drawable.s1)


        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as BusinessDataView
            mListener?.onBusinessClick(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_business, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(mValues != null){
            val item = mValues?.get(position)
            holder.mIdView.text = item?.name
            holder.mContentView.text = item?.description
            holder.mCategory.text = item?.categories?.first()?.name

            Glide.with(context)
                    .load(item?.image)
                    .apply(glideOptions)
                    .transition(GenericTransitionOptions.with(R.anim.alpha_anim))
                    .into(holder.ivBusiness)


            with(holder.mView) {
                tag = item
                setOnClickListener(mOnClickListener)
            }

            setAnimation((holder).itemView, position)
        }

    }

    fun setAnimation(viewToAnimate: View, position: Int) {
        val animation = AnimationUtils.loadAnimation(context, R.anim.abc_grow_fade_in_from_bottom)
        viewToAnimate.startAnimation(animation)
        //lastPosition = position
    }

    override fun getItemCount(): Int {
        if(mValues != null){
           return  mValues!!.size
        }
        return 0
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.tvBusinessTitle
        val mContentView: TextView = mView.tvContent
        val mCategory: TextView = mView.tvCategory
        val ivBusiness: AppCompatImageView = mView.ivBusiness

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
