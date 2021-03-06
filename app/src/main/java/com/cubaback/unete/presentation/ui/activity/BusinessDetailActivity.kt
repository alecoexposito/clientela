package com.cubaback.unete.presentation.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.lifecycle.Observer
import com.bumptech.glide.GenericTransitionOptions
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cubaback.unete.R
import com.cubaback.unete.presentation.data.ResourceState
import com.cubaback.unete.presentation.model.BusinessDataView
import com.cubaback.unete.presentation.ui.custom.detail.DependencesView
import com.cubaback.unete.presentation.ui.custom.detail.DescriptionView
import com.cubaback.unete.presentation.ui.custom.detail.RelatedCategoriesView
import com.cubaback.unete.presentation.view_model.BusinessViewModel
import com.cubaback.unete.presentation.view_model.custom_views.TextBlockViewModel
import kotlinx.android.synthetic.main.activity_business_detail.*
import kotlinx.android.synthetic.main.content_detail.*
import org.koin.android.viewmodel.ext.android.viewModel

class BusinessDetailActivity : BaseActivity() {

    var businessId : Long = 0
    private val  businessViewModel : BusinessViewModel  by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_business_detail)

        if(intent.hasExtra(EXTRA_BUSINESS)){
            businessId = intent.getLongExtra(EXTRA_BUSINESS, 0)
        }

        bindBusinessViewModel()
    }

    override fun onStart() {
        super.onStart()
        businessViewModel.getBusinessById(businessId)
    }


    private fun bindBusinessViewModel(){
        businessViewModel.selectedBusiness.observe(this, Observer {
            it?.let { it1 ->
                handlerBusinessResource(it1.status, it1.data, it1.throwable)
            }
        })
    }

    private fun handlerBusinessResource(status: ResourceState, data: BusinessDataView?, t: Throwable?) {
        when(status){
            ResourceState.LOADING -> setupScreenForLoadingState()
            ResourceState.SUCCESS -> setupScreenForBusiness(data)
            ResourceState.ERROR -> handlerError(t!!)
        }
    }

    @SuppressLint("CheckResult", "SetTextI18n")
    private fun setupScreenForBusiness(data: BusinessDataView?) {
        val glideOptions = RequestOptions()
        glideOptions.placeholder(R.drawable.s1)

        glideOptions.error(R.drawable.s1)

        data?.let {
            Glide.with(this)
                    .load(data.image)
                    .transition(GenericTransitionOptions.with(R.anim.alpha_anim))
                    .apply(glideOptions)
                    .into(ivBusiness)

            container.removeAllViews()

            // Add Description...
            val descriptionView =  DescriptionView(this, getString(R.string.description), it.description!!)
            container.addView(descriptionView)

            //Add dependences
            it.dependence?.let {v->
                val dependencesView =  DependencesView(this, getString(R.string.dependences), v)
                container.addView(dependencesView)
            }

            // Add categories
            it.categories?.let {v->
                val categoryView = RelatedCategoriesView(this, getString(R.string.categories_related),  v)
                container.addView(categoryView)
            }

            tvTitle.textBlockViewModel = TextBlockViewModel(it.categories?.first()?.name!!, it.name!!)
        }

        dismissLoading()
    }


    companion object {
        val EXTRA_BUSINESS = "${javaClass.simpleName}.extra_business_id"
    }
}
