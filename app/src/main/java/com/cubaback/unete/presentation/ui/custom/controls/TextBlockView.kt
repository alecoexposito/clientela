package com.cubaback.unete.presentation.ui.custom.controls

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.cubaback.unete.R
import com.cubaback.unete.presentation.view_model.custom_views.TextBlockViewModel
import kotlinx.android.synthetic.main.view_text_block.view.*

/**
 * View class to show all text block
 *
 * Label : Header label
 * Content: content to show
 */
class TextBlockView : LinearLayout {


    var textBlockViewModel : TextBlockViewModel? = null
        set(value) {
        field = value
        fillUi()
    }

    constructor(context: Context, textBlockViewModel: TextBlockViewModel) : super(context) {
        init(null, 0)
        this.textBlockViewModel = textBlockViewModel
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        inflate(getContext(), R.layout.view_text_block, this)

    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        fillUi()
    }

    private fun fillUi(){
        textBlockViewModel?.let {
            tvHeader.text = it.label
            tvContent.text = it.value
        }
    }



}
