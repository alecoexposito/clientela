package com.cubaback.unete.presentation.ui.fragment.publicity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cubaback.unete.R
import com.cubaback.unete.presentation.data.ResourceState
import com.cubaback.unete.presentation.model.AdvertisementView
import com.cubaback.unete.presentation.ui.fragment.BaseFragment
import com.cubaback.unete.presentation.view_model.AdvertisementViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class AdvertisementFragment : BaseFragment() {


    private var columnCount = 1
    private var listener: OnListFragmentInteractionListener? = null
    lateinit var advertisementAdapter : AdvertisementAdapter

    private val advertisementViewModel : AdvertisementViewModel by viewModel()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_advertisement_list, container, false)
        advertisementAdapter = AdvertisementAdapter(activity!!,listener)

        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }

            }
            view.adapter = advertisementAdapter
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        advertisementViewModel.advertisementLiveData.observe(this, Observer {
            it?.apply {
                handlerAdvertisements(it.status, it.data, it.message)
            }
        })
        setupUi()
    }

    private fun handlerAdvertisements(status: ResourceState, data: List<AdvertisementView>?, message: String?) {
        when(status){
            ResourceState.LOADING -> setupScreenForLoadingState()
            ResourceState.SUCCESS -> setupForAdvertisementSuccessLoaded(data)
            ResourceState.ERROR -> setupScreenForLoginError(message)
        }
    }

    private fun setupForAdvertisementSuccessLoaded(data: List<AdvertisementView>?) {
        advertisementAdapter?.let {
            if(data != null){
                it.mAdvertisements = data
            }
        }
    }

    private fun setupUi(){
        advertisementViewModel.getAdvertisement()
    }




















    interface OnListFragmentInteractionListener {
        fun onListFragmentInteraction(item: AdvertisementView?)
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
                AdvertisementFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_COLUMN_COUNT, columnCount)
                    }
                }
    }
}
