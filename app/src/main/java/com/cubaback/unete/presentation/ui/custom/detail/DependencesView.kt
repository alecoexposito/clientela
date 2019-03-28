package com.cubaback.unete.presentation.ui.custom.detail

import android.content.Context
import android.util.AttributeSet
import com.cubaback.unete.presentation.model.DependencesDataView
import kotlinx.android.synthetic.main.view_detail.view.*

open class DependencesView : BaseDetailView {
    lateinit var dependences : List<DependencesDataView>

    constructor(context: Context, title: String,  dependences : List<DependencesDataView>) : super(context, title){
        this.dependences = dependences
    }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)


    override fun fillUi() {
        super.fillUi()
        dependences.forEach {
            itemsContainer.addView(DependenceView(context, it))
        }
    }
}