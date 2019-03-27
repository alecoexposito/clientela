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
import com.cubaback.unete.presentation.ui.custom.BaseHolder
import com.cubaback.unete.presentation.ui.custom.EmptyViewHolder


import com.cubaback.unete.presentation.ui.fragment.publicity.AdvertisementFragment.OnListFragmentInteractionListener

import kotlinx.android.synthetic.main.fragment_advertisement.view.*


class AdvertisementAdapter(private val context : Context, private val mListener: OnListFragmentInteractionListener?)
    : RecyclerView.Adapter<BaseHolder>() {

    private val mOnClickListener: View.OnClickListener
    private val VIEW_TYPE_EMPTY_LIST = 0
    private val VIEW_TYPE_ADVERTISEMENT = 1



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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        val view : View
        return if(viewType == VIEW_TYPE_EMPTY_LIST){
            view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_empty, parent, false)
            EmptyViewHolder(view)
        } else{
            view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.fragment_advertisement, parent, false)
            AdvertisementHolder(view)
        }
    }

    override fun onBindViewHolder(holder: BaseHolder, position: Int) {
        mAdvertisements?.apply {
            if (mAdvertisements.isNullOrEmpty()){
                (holder as EmptyViewHolder).mTextView.text = context.getString(R.string.not_such_element, context.getString(R.string.advertisement))
            } else{
                val item = this[position]
                (holder as AdvertisementHolder).mTitleView.text = item.title
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

    }

    fun setAnimation(viewToAnimate: View, position: Int) {
        val animation = AnimationUtils.loadAnimation(context, R.anim.zoom_in)
        viewToAnimate.startAnimation(animation)

    }

    override fun getItemViewType(position: Int): Int {
        if(mAdvertisements.isNullOrEmpty()) return VIEW_TYPE_EMPTY_LIST
        return VIEW_TYPE_ADVERTISEMENT
    }

    override fun getItemCount(): Int {
        if(!mAdvertisements.isNullOrEmpty()){
            return  mAdvertisements!!.size
        }
        return 1
    }

    inner class AdvertisementHolder(mView: View) : BaseHolder(mView) {
        val mTitleView: TextView = mView.tvTitle
        val mContentView: TextView = mView.tvContent
        val ivAdvertisement : ImageView = mView.ivAdvertisement

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
