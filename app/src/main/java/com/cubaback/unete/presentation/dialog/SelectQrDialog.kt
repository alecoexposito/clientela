package com.cubaback.unete.presentation.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.cubaback.unete.R
import kotlinx.android.synthetic.main.dialog_qr_selector.view.*
import org.jetbrains.anko.layoutInflater

class SelectQrDialog : DialogFragment {
    constructor() : super()

    lateinit var customView: View
    private lateinit var dialogCallback : SelectQrCallback

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
    {
        return customView
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        customView = context!!.layoutInflater.inflate(R.layout.dialog_qr_selector, null)


        val dialog = AlertDialog.Builder(context!!)
                .setTitle("Seleccione la operacion")
                .setView(customView)
                .create()

        customView.btnShowId.setOnClickListener {
            dialogCallback.onShowIdClick()
            dismiss()
        }
        customView.btnScanQr.setOnClickListener {
            dialogCallback.onScanClick()
            dismiss()
        }

        return dialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

    }


    fun setDialogFragmentListener(selectQrCallback: SelectQrCallback){
        this.dialogCallback = selectQrCallback
    }

    companion object {
        val TAG = javaClass.canonicalName
    }


    interface SelectQrCallback{
        fun onScanClick()
        fun onShowIdClick()
    }

}