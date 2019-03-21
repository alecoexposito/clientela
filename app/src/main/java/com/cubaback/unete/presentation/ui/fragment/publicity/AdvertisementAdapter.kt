package com.cubaback.unete.presentation.ui.fragment.publicity

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cubaback.unete.R
import com.cubaback.unete.presentation.model.AdvertisementView


import com.cubaback.unete.presentation.ui.fragment.publicity.AdvertisementFragment.OnListFragmentInteractionListener

import kotlinx.android.synthetic.main.fragment_advertisement.view.*


class AdvertisementAdapter(private val context : Context, private val mListener: OnListFragmentInteractionListener?)
    : RecyclerView.Adapter<AdvertisementAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    var mAdvertisements: List<AdvertisementView>? = null
        set(value){
            field = value
            notifyDataSetChanged()
        }


    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as AdvertisementView
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_advertisement, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        mAdvertisements?.apply {
            val item = this[position]
            holder.mTitleView.text = item.title
            holder.mContentView.text = item.description

            val glideOptions1 = RequestOptions()
            glideOptions1.placeholder(R.drawable.s1)
            glideOptions1.error(R.drawable.s1)

            Glide.with(context)
                    .load(item.image)
                    .apply(glideOptions1)
                    .into(holder.ivAdvertisement)


            with(holder.mView) {
                tag = item
                setOnClickListener(mOnClickListener)
            }

            setAnimation((holder).itemView, position)
        }

    }

    fun setAnimation(viewToAnimate: View, position: Int) {
        val animation = AnimationUtils.loadAnimation(context, R.anim.zoom_in)
        viewToAnimate.startAnimation(animation)

    }

    override fun getItemCount(): Int {
        if(mAdvertisements != null){
            return  mAdvertisements!!.size
        }
        return 0
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mTitleView: TextView = mView.tvTitle
        val mContentView: TextView = mView.tvContent
        val ivAdvertisement : ImageView = mView.ivAdvertisement

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
