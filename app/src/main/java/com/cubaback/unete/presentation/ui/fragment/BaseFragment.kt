package com.cubaback.unete.presentation.ui.fragment

import androidx.fragment.app.Fragment
import com.cubaback.unete.R
import org.jetbrains.anko.okButton
import org.jetbrains.anko.support.v4.alert
import org.jetbrains.anko.support.v4.toast

open abstract  class BaseFragment : Fragment() {

    open fun setupScreenForLoginError(message: String?) {
        message?.let {

            alert (message =  it){
                okButton { it.dismiss() }
                show()
            }
//            val alertDialog : LottieAlertDialog
//
//            alertDialog= LottieAlertDialog.Builder(activity,DialogTypes.TYPE_ERROR)
//                    .setTitle(getString(R.string.error))
//                    .setDescription(it)
//                    .setPositiveListener(positiveListener = object : ClickListener{
//                        override fun onClick(dialog: LottieAlertDialog) {
//                            dialog.dismiss()
//                        }
//                    })
//                    .build()
//            alertDialog.setCancelable(false)
//            alertDialog.show()
        }
    }

    protected fun setupScreenForLoadingState() {
        toast(getString(R.string.loading_msg))
//        val alertDialog : LottieAlertDialog = LottieAlertDialog.Builder(activity,DialogTypes.TYPE_LOADING)
//                .setTitle(getString(R.string.loading_msg))
//                .setDescription(getString(R.string.please_wait))
//                .build()
//        alertDialog.setCancelable(false)
//        alertDialog.show()
    }

}