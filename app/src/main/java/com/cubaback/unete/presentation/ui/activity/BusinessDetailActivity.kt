package com.cubaback.unete.presentation.ui.activity

import android.os.Bundle
import android.app.Activity
import com.cubaback.unete.R
import com.cubaback.unete.data.model.BusinessView

class BusinessDetailActivity : Activity() {

    lateinit var business : BusinessView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_detail)
    }

    private fun fillBusinessData(){
        // todo: llenar los datos del negocio...
    }


    companion object {
        val EXTRA_BUSINESS = "extra_business"
    }
}
