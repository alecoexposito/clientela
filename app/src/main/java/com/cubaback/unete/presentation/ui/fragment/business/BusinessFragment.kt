package com.cubaback.unete.presentation.ui.fragment.business

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.cubaback.unete.R
import com.cubaback.unete.data.model.BusinessView
import com.cubaback.unete.presentation.data.ResourceState
import com.cubaback.unete.presentation.view_model.BusinessViewModel
import kotlinx.android.synthetic.main.fragment_business_list.view.*
import org.jetbrains.anko.support.v4.toast
import org.koin.android.viewmodel.ext.android.viewModel

class BusinessFragment : Fragment() {


    private var columnCount = 1
    private var listener: BusinessFragmentCallback? = null
    private var adapter : BusinessAdapter? = null

    val businessViewModel: BusinessViewModel by viewModel()

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

        with(view.list) {
            layoutManager = when {
                columnCount <= 1 -> LinearLayoutManager(context)
                else -> GridLayoutManager(context, columnCount)
            }
            adapter = BusinessAdapter(listener, context)
        }



        return view
    }

    override fun onStart() {
        super.onStart()
        setupBusinessViewModel()
        businessViewModel.getBusinesses()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_business, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    fun setupBusinessViewModel(){
        businessViewModel.businessLiveData.observe(this, Observer {
            if (it != null){
                handlerBusinessResponse(it.status, it.data, it.message)
            }
        })
    }

    fun handlerBusinessResponse(state: ResourceState?, data : List<BusinessView>?, message : String?){
        when(state){
            ResourceState.LOADING -> setupScreenForLoading()
            ResourceState.SUCCESS -> setupScreenForLoadedBusinesses(data)
            ResourceState.ERROR -> setupScreenForError(message)
        }

    }

    private fun setupScreenForError( message : String?) {
        toast("Error!!!")
    }

    private fun setupScreenForLoadedBusinesses(data : List<BusinessView>?) {
        var a = data
//        adapter?.let {
//            if(data != null){
//                it.mValues = data
//            }
//        }
    }

    private fun setupScreenForLoading() {
        toast("Cargando")
    }


    interface BusinessFragmentCallback {
        fun onBusinessClick(item : BusinessView)
    }



    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
                BusinessFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_COLUMN_COUNT, columnCount)
                    }
                }
    }
}
