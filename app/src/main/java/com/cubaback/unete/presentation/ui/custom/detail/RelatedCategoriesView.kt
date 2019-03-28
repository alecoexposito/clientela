package com.cubaback.unete.presentation.ui.custom.detail

import android.content.Context
import android.util.AttributeSet
import com.cubaback.unete.R
import com.cubaback.unete.presentation.model.CategoryDataView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import kotlinx.android.synthetic.main.view_detail.view.*

open class RelatedCategoriesView : BaseDetailView {

    lateinit var categories : List<CategoryDataView>

    constructor(context: Context, title: String,  categories : List<CategoryDataView>) : super(context, title){
        this.categories = categories
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)


    override fun getLayoutId(): Int {
        return  R.layout.view_detail
    }

    override fun fillUi() {
        super.fillUi()
        showTags()
    }

    private fun showTags(){
        val chipGroup = ChipGroup(context)
        categories.forEach {
            val chip = Chip(context)
            chip.text = it.name
            chipGroup.addView(chip)
        }
         itemsContainer.addView(chipGroup)
    }
}