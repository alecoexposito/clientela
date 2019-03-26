package com.cubaback.unete.presentation.ui.fragment

import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.cubaback.unete.R
import com.labters.lottiealertdialoglibrary.ClickListener
import com.labters.lottiealertdialoglibrary.DialogTypes
import com.labters.lottiealertdialoglibrary.LottieAlertDialog
import org.jetbrains.anko.allCaps
import org.jetbrains.anko.okButton
import org.jetbrains.anko.support.v4.alert
import org.jetbrains.anko.support.v4.toast

open abstract  class BaseFragment : Fragment() {

    lateinit var loadingDialog : LottieAlertDialog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadingDialog = LottieAlertDialog.Builder(activity, DialogTypes.TYPE_LOADING)
                .setTitle(getString(R.string.loading_msg))
                .setDescription(getString(R.string.please_wait))
                .build()
    }

    open fun setupScreenForError(message: String?) {
        dismissLoading()
        message?.let {
            val alertDialog : LottieAlertDialog
            alertDialog = LottieAlertDialog.Builder(activity,DialogTypes.TYPE_ERROR)
                    .setTitle(getString(R.string.error))
                    .setDescription(it)
                    .setPositiveText(getString(R.string.error))
                    .setPositiveButtonColor(resources.getColor(R.color.colorAccent))
                    .setPositiveTextColor(resources.getColor(R.color.white))
                    .setPositiveListener(positiveListener = object : ClickListener {
                        override fun onClick(dialog: LottieAlertDialog) {
                            dialog.dismiss()
                        }
                    })

                    .build()
            alertDialog.setCancelable(false)
         //   alertDialog.getButton(Dialog.BUTTON_POSITIVE).allCaps = false
            alertDialog.show()
        }
    }

    protected fun setupScreenForLoadingState() {
        loadingDialog.setCancelable(false)
        loadingDialog.show()
    }

    protected fun dismissLoading(){
        loadingDialog.dismiss()
    }

}