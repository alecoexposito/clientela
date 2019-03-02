package com.cubaback.unete.presentation.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.cubaback.unete.R

/**
 * TODO: document your custom view class.
 */
class CommonDetailView : LinearLayout {
    lateinit var title : String
    lateinit var items : List<String>

    constructor(context: Context, title : String, items : List<String>) : super(context) {
        init(null, 0)
        this.title = title
        this.items = items
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

    private fun fillUi(){

    }


}
