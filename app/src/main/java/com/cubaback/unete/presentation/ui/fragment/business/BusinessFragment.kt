package com.cubaback.unete.presentation.ui.fragment.business

import android.os.Bundle
import android.view.*
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.cubaback.unete.R
import com.cubaback.unete.presentation.model.BusinessView
import com.cubaback.unete.data.model.CategoryView
import com.cubaback.unete.presentation.data.ResourceState
import com.cubaback.unete.presentation.ui.fragment.BaseFragment
import com.cubaback.unete.presentation.view_model.BusinessViewModel
import com.cubaback.unete.presentation.view_model.CategoryViewModel
import kotlinx.android.synthetic.main.fragment_business_list.view.*
import kotlinx.android.synthetic.main.view_subcategories_list.view.*
import org.koin.android.viewmodel.ext.android.viewModel

open class BusinessFragment : BaseFragment() {


    private var columnCount = 1
    protected lateinit var listener: BusinessFragmentCallback
    protected var businessAdapter : BusinessAdapter? = null
    protected lateinit var categoryAdapter : TopCategoryAdapter

    protected val businessViewModel: BusinessViewModel by viewModel()
    protected val categoryViewModel: CategoryViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }

        setHasOptionsMenu(true)
    }


    fun setBusinessFragmentCallback(businessFragmentCallback: BusinessFragmentCallback){
        this.listener = businessFragmentCallback
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_business_list, container, false)
        setupUi(view)
        return view
    }

    open fun setupUi(view : View){
        // setup business adapter...
        with(view.list) {
            layoutManager = when {
                columnCount <= 1 -> LinearLayoutManager(context)
                else -> GridLayoutManager(context, columnCount)
            }
        }

        businessAdapter = activity?.let { BusinessAdapter(listener, it) }
        view.list.adapter = this.businessAdapter

        // setup category adapter...
        with(view.categories){
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false )
            categoryAdapter = TopCategoryAdapter(listener, context)
            this.adapter = categoryAdapter
        }
    }

    override fun onStart() {
        super.onStart()
        bindBusinessViewModel()
        bindCategoryViewModel()
        initDatas()
    }

    open fun initDatas(){
        businessViewModel.getBusinesses()
        categoryViewModel.getCategories()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_business, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

   private fun bindBusinessViewModel(){
        businessViewModel.businessLiveData.observe(this, Observer {
            if (it != null){
                handlerBusinessResponse(it.status, it.data, it.message)
            }
        })
    }

   private fun bindCategoryViewModel(){
        categoryViewModel.categoriesLiveData.observe(this, Observer {
            it?.apply {
                handlerCategoryResponse(it.status, it.data, it.message)
            }
        })
    }

   private fun handlerBusinessResponse(state: ResourceState?, data : List<BusinessView>?, message : String?){
        when(state){
            ResourceState.LOADING -> setupScreenForLoadingState()
            ResourceState.SUCCESS -> setupScreenForLoadedBusinesses(data)
            ResourceState.ERROR -> setupScreenForError(message)
        }
    }

   private fun handlerCategoryResponse(state: ResourceState?, data : List<CategoryView>?, message : String?){
        when(state){
            ResourceState.LOADING -> setupScreenForLoadingState()
            ResourceState.SUCCESS -> setupScreenForLoadedCategories(data)
            ResourceState.ERROR -> setupScreenForError(message)
        }
    }

    open fun setupScreenForLoadedCategories(data: List<CategoryView>?) {
        categoryAdapter?.let {
            if(data != null){
                it.mCategories = data.filter { it.parentId == null }
            }
        }
    }

    open fun setupScreenForLoadedBusinesses(data : List<BusinessView>?) {
        businessAdapter?.let {
            if(data != null){
                it.mValues = data
            }
        }
        dismissLoading()
    }

    interface BusinessFragmentCallback {
        fun onBusinessClick(item : BusinessView)
        fun onCategoryClick(item : CategoryView)
    }

    companion object {
        const val ARG_COLUMN_COUNT = "column-count"
        @JvmStatic
        fun newInstance(columnCount: Int) =
                BusinessFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_COLUMN_COUNT, columnCount)
                    }
                }
    }
}
