package com.cubaback.unete.presentation.ui.fragment.business

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cubaback.unete.R
import com.cubaback.unete.cache.PreferencesHelper
import com.cubaback.unete.data.model.BusinessView
import kotlinx.android.synthetic.main.fragment_business.view.*

/**
 * [RecyclerView.Adapter] that can display a [BusinessView] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class BusinessAdapter(
        private val mListener: BusinessFragment.BusinessFragmentCallback?,
        private val context : Context)
    : RecyclerView.Adapter<BusinessAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    var mValues: List<BusinessView>
        get() = mValues
        set(value) {
            mValues = value
            notifyDataSetChanged()
        }

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as BusinessView
            mListener?.onBusinessClick(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_business, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mIdView.text = "Perla Negra"
        holder.mContentView.text = item.description

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }

        setAnimation((holder as ViewHolder).itemView, position)
    }

    fun setAnimation(viewToAnimate: View, position: Int) {
        val animation = AnimationUtils.loadAnimation(context, R.anim.zoom_in)
        viewToAnimate.startAnimation(animation)
        //lastPosition = position
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.tvBusinessTitle
        val mContentView: TextView = mView.tvContent

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
