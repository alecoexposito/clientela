package com.cubaback.unete.presentation.ui.custom.detail

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.cubaback.unete.R
import com.cubaback.unete.presentation.ui.custom.ItemsType
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import kotlinx.android.synthetic.main.view_detail.view.*
import org.jetbrains.anko.dip
import org.jetbrains.anko.textView

/**
 * View used for fill all datas in Details View
 * */
abstract class BaseDetailView : LinearLayout {
    lateinit var title : String
    var collapsed = false

    constructor(context: Context, title : String = "") : super(context) {
        init(null, 0)
        this.title = title
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init(attrs, defStyle)
    }

    open fun init(attrs: AttributeSet?, defStyle: Int) {
        getLayoutId()?.let {  inflate(context,  it, this) }

    }

    open fun getLayoutId() : Int?{
        return R.layout.view_detail
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        fillUi()
    }

    open fun fillUi(){
        getLayoutId()?.let{
            itemsContainer.removeAllViews()
            tvTitle.text = this.title

            tvTitle.setOnClickListener {
                // todo: Correr animacion.. y cambiar icono
                if(!collapsed){
                    itemsContainer.visibility = View.GONE
                } else{
                    itemsContainer.visibility = View.VISIBLE
                }
                collapsed = !collapsed
            }


        }
    }

}
