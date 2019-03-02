package com.cubaback.unete.presentation.fragment.notification

import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatImageView
import com.cubaback.unete.R


import com.cubaback.unete.presentation.fragment.notification.NotificationFragment.OnListFragmentInteractionListener
import com.cubaback.unete.presentation.fragment.notification.dummy.DummyContent.DummyItem
import com.google.android.material.circularreveal.cardview.CircularRevealCardView

import kotlinx.android.synthetic.main.fragment_notification.view.*

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class NotificationAdapter(
        private val mValues: List<DummyItem>,
        private val mListener: OnListFragmentInteractionListener?,
        private val context : Context)
    : RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as DummyItem
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_notification, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mIdView.text = item.id
        holder.mContentView.text = item.content
        val color = if (item.read) context.resources.getColor(R.color.white) else context.resources.getColor(R.color.ligther_green)
        val icon = if (item.read) R.drawable.ic_notifications_off else R.drawable.ic_notifications_active
        holder.setRead(color)
        holder.ivNotificationIcon.setImageResource(icon)

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.tvNotificationTitle
        val mContentView: TextView = mView.tvContent
        val mainCard: CircularRevealCardView = mView.mainCard
        val ivNotificationIcon : AppCompatImageView  = mView.ivNotificationIcon

        fun setRead(color : Int){
            mainCard.setCardBackgroundColor(color)
        }

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
