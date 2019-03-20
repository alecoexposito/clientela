package com.cubaback.unete.presentation.ui.fragment

import androidx.fragment.app.Fragment
import org.jetbrains.anko.support.v4.alert
import org.jetbrains.anko.support.v4.toast

open abstract  class BaseFragment : Fragment() {

    protected fun setupScreenForLoginError(message: String?) {
        alert ("Error")
    }

    protected fun setupScreenForLoadingState() {
        toast("Cargando")
    }

}