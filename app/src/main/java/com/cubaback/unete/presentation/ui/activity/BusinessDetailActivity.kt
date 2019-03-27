package com.cubaback.unete.presentation.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.bumptech.glide.GenericTransitionOptions
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cubaback.unete.R
import com.cubaback.unete.presentation.data.ResourceState
import com.cubaback.unete.presentation.model.BusinessView
import com.cubaback.unete.presentation.ui.custom.CommonDetailView
import com.cubaback.unete.presentation.ui.custom.ItemsType
import com.cubaback.unete.presentation.view_model.BusinessViewModel
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
                handlerBusinessResource(it1.status, it1.data, it1.message)
            }
        })
    }

    private fun handlerBusinessResource(status: ResourceState, data: BusinessView?, message: String?) {
        when(status){
            ResourceState.LOADING -> setupScreenForLoadingState()
            ResourceState.SUCCESS -> setupScreenForBusiness(data)
            ResourceState.ERROR -> setupScreenForError(message)
        }
    }

    @SuppressLint("CheckResult", "SetTextI18n")
    private fun setupScreenForBusiness(data: BusinessView?) {
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
            val descriptionView = CommonDetailView(context = this,
                    title = getString(R.string.description),
                    items = listOf(it.description!!),
                    itemsType = ItemsType.TEXT)


            container.addView(descriptionView)

            //Add dependences
            val dependenceView = CommonDetailView(this,
                    getString(R.string.dependences),
                    listOf("${getString(R.string.name)}: ${it.dependence!!.name}", "${getString(R.string.description)}: ${it.dependence!!.description}" ),
                    ItemsType.NO_ENUMERATE_LIST)

            container.addView(dependenceView)

            val categoriesName = it.categories!!.map {it1 -> it1.name!! }

            val categoriesViewTag = CommonDetailView(this,
                        getString(R.string.categories_related),
                        categoriesName,
                        ItemsType.TAGS)

            container.addView(categoriesViewTag)


            tvTitle.text = "${it.categories?.first()?.name}: ${it.name}"
        }

        dismissLoading()
    }


    companion object {
        val EXTRA_BUSINESS = "${javaClass.simpleName}.extra_business_id"
    }
}
