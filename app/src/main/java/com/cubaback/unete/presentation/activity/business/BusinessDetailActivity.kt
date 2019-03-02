package com.cubaback.unete.presentation.activity.business

import android.os.Bundle
import android.app.Activity
import com.cubaback.unete.R
import com.cubaback.unete.data.model.Business

class BusinessDetailActivity : Activity() {

    lateinit var business : Business

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
