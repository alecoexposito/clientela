package com.cubaback.unete.presentation.ui.fragment.business
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cubaback.unete.R
import com.cubaback.unete.presentation.ui.fragment.BaseFragment
import com.cubaback.unete.presentation.view_model.CategoryViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class SubCategoryFragment : BaseFragment() {

    private var listener: SubcategoryFragmentCallback? = null
    val categoryViewModel : CategoryViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_sub_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSubCategoryDatas()
    }


    fun initSubCategoryDatas(/*catView : CategoryView*/){
       categoryViewModel.fillSubCategories(35)
       var a =  categoryViewModel.subCategoriesLiveData.value
    }


    interface SubcategoryFragmentCallback{

    }
}
