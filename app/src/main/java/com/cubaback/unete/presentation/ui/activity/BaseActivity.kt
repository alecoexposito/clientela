package com.cubaback.unete.presentation.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cubaback.unete.R
import com.cubaback.unete.presentation.view_model.UserViewModel
import com.labters.lottiealertdialoglibrary.ClickListener
import com.labters.lottiealertdialoglibrary.DialogTypes
import com.labters.lottiealertdialoglibrary.LottieAlertDialog
import org.jetbrains.anko.startActivity
import org.koin.android.viewmodel.ext.android.viewModel
import retrofit2.HttpException

open class BaseActivity : AppCompatActivity() {

    private lateinit var loadingDialog : LottieAlertDialog
    private val loginViewModel: UserViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadingDialog = LottieAlertDialog.Builder(this, DialogTypes.TYPE_LOADING)
                .setTitle(getString(R.string.loading_msg))
                .setDescription(getString(R.string.please_wait))
                .build()
    }

    private fun openIntroActivity(){
        loginViewModel.logOut()
        startActivity<IntroActivity>()
    }


    open fun handlerError(t : Throwable) {
       val error = when {
           t is HttpException && t.code() == 401 -> {
               setupScreenForError( getString(R.string.unautorized)) {openIntroActivity()}
               return
           }

           t is HttpException && t.code() == 404 -> {
               if(t.response().errorBody()?.string()?.contains("user_not_found")!!){
                   setupScreenForError(getString(R.string.user_not_found))
               }
               return
           }
           else -> t.message
        }
        setupScreenForError(error)
    }

    open fun setupScreenForError(message: String?, f: (() -> Any?)? = null) {
        dismissLoading()
        message?.let {
            val alertDialog : LottieAlertDialog
            alertDialog = LottieAlertDialog.Builder(this, DialogTypes.TYPE_ERROR)
                    .setTitle(getString(R.string.error))
                    .setDescription(it)
                    .setPositiveText(getString(R.string.error))
                    .setPositiveButtonColor(resources.getColor(R.color.colorAccent))
                    .setPositiveTextColor(resources.getColor(R.color.white))

                    .setPositiveListener(positiveListener = object : ClickListener {
                        override fun onClick(dialog: LottieAlertDialog) {
                            if (f != null) {
                                f()
                            }
                            dialog.dismiss()
                        }
                    })
                    .build()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
    }

    open fun setupScreenForLoadingState() {
        loadingDialog.setCancelable(false)
        loadingDialog.show()
    }

    open fun dismissLoading(){
        loadingDialog.dismiss()
    }
}


