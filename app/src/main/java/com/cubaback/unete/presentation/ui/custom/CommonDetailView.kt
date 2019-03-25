package com.cubaback.unete.presentation.ui.custom

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.cubaback.unete.R
import kotlinx.android.synthetic.main.view_common_detail.view.*
import org.jetbrains.anko.dip
import org.jetbrains.anko.textView

/**
 * View used for fill all datas in Details View
 * */
class CommonDetailView : LinearLayout {
    lateinit var title : String
    lateinit var items : List<String>
    lateinit var itemsType: ItemsType

    constructor(context: Context, title : String, items : List<String>, itemsType: ItemsType) : super(context) {
        init(null, 0)
        this.title = title
        this.items = items
        this.itemsType = itemsType


    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        inflate(getContext(), R.layout.view_common_detail, this)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        fillUi()
    }

    private fun fillUi(){
        itemsContainer.removeAllViews()
        when(itemsType){
           ItemsType.ENUMERATE_LIST -> listEnumetaredItems()
           ItemsType.NO_ENUMERATE_LIST -> listNoEnumerateItems()
           ItemsType.TEXT -> showNormalText()
       }
        tvTitle.text = this.title
    }



    private fun showNormalText() {
        var textToShow = ""
        items.forEach {
            textToShow += "$it \n"
        }

        val textView = textView{
            text = textToShow

        }
        (textView.parent as LinearLayout).removeView(textView)

        itemsContainer.addView(textView)
    }

    private fun listNoEnumerateItems() {
        items.forEach {
            val textView = textView{
                text = it
                setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_point, 0, 0, 0)
                compoundDrawablePadding = dip(4)
            }

            (textView.parent as LinearLayout).removeView(textView)
            itemsContainer.addView(textView)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun listEnumetaredItems() {
        items.forEachIndexed { index, s ->
            val textView = textView{
                text = "$index - $s"
            }
            (textView.parent as LinearLayout).removeView(textView)
            itemsContainer.addView(textView)
        }
    }


}
