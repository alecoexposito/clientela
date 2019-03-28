package com.cubaback.unete.presentation.ui.custom.detail

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.cubaback.unete.R
import kotlinx.android.synthetic.main.view_detail.view.*
import org.jetbrains.anko.textView

class DescriptionView : BaseDetailView {
    lateinit var description: String

    constructor(context: Context, title: String = "",  description: String = "") : super(context, title) {
        this.description = description
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

    override fun getLayoutId(): Int {
        return  R.layout.view_detail
    }

    override fun fillUi() {
        super.fillUi()
        showNormalText()
    }

    private fun showNormalText() {
        val textView = textView{
            text = description
        }
        (textView.parent as LinearLayout).removeView(textView)
        itemsContainer.addView(textView)
    }
}