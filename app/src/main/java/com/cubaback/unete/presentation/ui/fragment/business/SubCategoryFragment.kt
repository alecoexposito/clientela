package com.cubaback.unete.presentation.ui.fragment.business
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cubaback.unete.R
import com.cubaback.unete.data.model.CategoryView

class SubCategoryFragment : BusinessFragment() {
    private val EXTRA_CATEGORY_PARENT_ID = "com.cubaback.joinus.category_parent_id"
    private var parentId : Long? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            parentId = it.getLong(EXTRA_CATEGORY_PARENT_ID)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_sub_category, container, false)
        setupUi(view)
        return view
    }

    override fun setupUi(view: View) {
        super.setupUi(view)
    }

    fun onCategoryClick(categoryView: CategoryView){
        businessViewModel.getBusinesses(categoryView.id)
    }

    override fun initDatas() {
        initSubCategoryDatas()
    }

    override fun setupScreenForLoadedCategories(data: List<CategoryView>?) {
        categoryAdapter?.let {
            if(data != null){
                it.mCategories = data
            }
            // select the first category and load businesses
            val firstCat = data?.first()
            businessViewModel.getBusinesses(firstCat?.id)
        }
    }

    private fun initSubCategoryDatas(){
       parentId?.let {  categoryViewModel.fillSubCategories(it)  }
    }

    companion object {
        @JvmStatic
        fun newInstance(parentId: Long) =
                SubCategoryFragment().apply {
                    arguments = Bundle().apply {
                        putLong(EXTRA_CATEGORY_PARENT_ID, parentId)
                    }
                }
    }

}
