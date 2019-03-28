package com.cubaback.unete.presentation.ui.custom.detail

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.cubaback.unete.R
import com.cubaback.unete.presentation.model.DependencesDataView
import com.cubaback.unete.presentation.view_model.custom_views.TextBlockViewModel
import kotlinx.android.synthetic.main.view_dependence.view.*

/*View that represent a dependence*/
open class DependenceView : LinearLayout {
    lateinit var dependencesView: DependencesDataView

    constructor(context: Context?, dependencesView: DependencesDataView) : super(context){
        init(null, 0)
        this.dependencesView = dependencesView
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        init(null, 0)
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        init(null, 0)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        inflate(context, R.layout.view_dependence, this)

    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        fillUi()
    }

    fun fillUi(){
        tvTitle.textBlockViewModel = TextBlockViewModel(context.getString(R.string.name), dependencesView.name!!)
        tvDescription.textBlockViewModel = TextBlockViewModel(context.getString(R.string.description), dependencesView.description!!)
    }
}