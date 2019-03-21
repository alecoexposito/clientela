package com.cubaback.unete.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cubaback.unete.R
import kotlinx.android.synthetic.main.fragment_intro.*


class IntroFragment : BaseFragment() {

    var listener: OnIntroFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_intro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setupUi()
    }

    private fun setupUi(){
        btnRegister.setOnClickListener { listener?.let { it.onRegisterClick() } }
        btnLogin.setOnClickListener{listener?.let { it.onLoginClick() }}
    }

  //  fun setIntroListener( listener: (view: OnIntroFragmentInteractionListener) -> Unit){}



    companion object {
        @JvmStatic
        fun newInstance( ) =
                IntroFragment().apply {
                }
    }



// fragment interaction....
    interface OnIntroFragmentInteractionListener {
        fun onRegisterClick()
        fun onLoginClick()
    }


}
