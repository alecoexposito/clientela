package com.cubaback.unete.presentation.ui.activity

import android.graphics.Bitmap
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cubaback.unete.R
import com.cubaback.unete.data.model.BusinessView
import com.cubaback.unete.data.model.CategoryView
import com.cubaback.unete.presentation.ui.dialog.SelectQrDialog
import com.cubaback.unete.presentation.ui.dialog.ShowIdDialog
import com.cubaback.unete.presentation.ui.fragment.business.BusinessFragment
import com.cubaback.unete.presentation.ui.fragment.business.SubCategoryFragment
import com.cubaback.unete.presentation.ui.fragment.notification.NotificationFragment
import com.cubaback.unete.presentation.ui.fragment.publicity.AdvertisementFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity(){

        private var publishFragment : AdvertisementFragment? = null
        lateinit var businessFragment : BusinessFragment
        private var notificationFragment : NotificationFragment? = null
        lateinit var subCategoryFragment : SubCategoryFragment

        private var bmpQr : Bitmap? = null

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            setSupportActionBar(toolbar)

            supportActionBar?.setDisplayHomeAsUpEnabled(false)
            supportActionBar?.setDisplayShowHomeEnabled(false)
            supportActionBar?.setDisplayShowTitleEnabled(false)

        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        bottomNavigation.selectedItemId = R.id.navigation_home

        setupCenterButton()
    }

    private fun openBusinessFragment(){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        businessFragment = BusinessFragment.newInstance(1)
        businessFragment.let { it.setBusinessFragmentCallback(object : BusinessFragment.BusinessFragmentCallback{
                override fun onBusinessClick(item: BusinessView) {
                    openBusinessDetailActivity(item)
                }

                override fun onCategoryClick(item: CategoryView) {
                    openSubCategoryFragment(item)
                }
        })  }

        businessFragment.let { fragmentTransition.replace(R.id.fragment_container, it) }
        fragmentTransition.commit()
    }


    private fun openPublishFragment(){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        publishFragment = AdvertisementFragment.newInstance(1)
        publishFragment?.let { fragmentTransition.replace(R.id.fragment_container, it) }
        fragmentTransition.commit()
    }

    private fun openNotificationFragment(){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        notificationFragment = NotificationFragment.newInstance(1)
        notificationFragment?.let { fragmentTransition.replace(R.id.fragment_container, it) }
        fragmentTransition.commit()
    }

    private fun openSubCategoryFragment(subCategoryView: CategoryView){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        subCategoryFragment = SubCategoryFragment()
        subCategoryFragment.let { fragmentTransition.replace(R.id.fragment_container, it) }
        fragmentTransition.commit()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                openPublishFragment()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_business -> {
                openBusinessFragment()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                openNotificationFragment()
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_space -> {
                openQrReader( )
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun setupCenterButton(){
        fab!!.setOnClickListener{openQrReader( )}
    }

    private fun openQrReader(){
         startActivity<QRScanActivity>()
    }

    private fun openBusinessDetailActivity(business : BusinessView){
        Companion.business = business
        startActivity<BusinessDetailActivity>(
               /* BusinessDetailActivity.EXTRA_BUSINESS to business*/)
    }



//    override fun onScanClick() {
//    }
//
//    override fun onShowIdClick() {
//        val showIdDialog = ShowIdDialog()
//        showIdDialog.show(supportFragmentManager, ShowIdDialog.TAG )
//    }

    companion object {
        var business : BusinessView? = null
    }
}
