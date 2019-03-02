package com.cubaback.unete.presentation.fragment.business

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.cubaback.unete.R
import com.cubaback.unete.presentation.fragment.business.dummy.DummyContent
import kotlinx.android.synthetic.main.fragment_business_list.view.*

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [BusinessFragment.OnListFragmentInteractionListener] interface.
 */
class BusinessFragment : Fragment() {

    // TODO: Customize parameters
    private var columnCount = 1

    private var listener: BusinessFragmentCallback? = null

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
            adapter = BusinessAdapter(DummyContent.ITEMS, listener, context)
        }

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_business, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    interface BusinessFragmentCallback {
        fun onBusinessClick(item : Business)
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
