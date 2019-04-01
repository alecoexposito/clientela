package com.cubaback.unete.presentation.ui.fragment.user

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.lifecycle.Observer
import com.cubaback.unete.R
import com.cubaback.unete.presentation.data.ResourceState
import com.cubaback.unete.presentation.model.UserDataView
import com.cubaback.unete.presentation.ui.activity.BaseActivity
import com.cubaback.unete.presentation.ui.dialog.DatePickerFragment
import com.cubaback.unete.presentation.ui.fragment.BaseFragment
import com.cubaback.unete.presentation.utils.Utils
import com.cubaback.unete.presentation.view_model.UserAction
import com.cubaback.unete.presentation.view_model.UserViewModel
import kotlinx.android.synthetic.main.fragment_register_step_two.*
import org.jetbrains.anko.AnkoLogger
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*


class SecondStepRegisterFragment : BaseFragment(), AnkoLogger {
    private val EXTRA_USER_EMAIL = "com.cubaback.joinus.user_id"

    private var userEmail: String? = null
    private var listener: RegisterTwoFragmentCallback? = null
    private val userViewModel : UserViewModel by viewModel()
    val cal = Calendar.getInstance()

    val logger = AnkoLogger(SecondStepRegisterFragment.javaClass.simpleName)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userEmail = it.getString(EXTRA_USER_EMAIL)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_register_step_two, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bidUserViewModel()

        // get user...
        userEmail?.let { userViewModel.getUserByEmail(it) }

        setupUi()
    }


    private fun bidUserViewModel(){
        userViewModel.registeredAndLoguedUser.observe(this, Observer {
            it?.let { it1 ->
                handlerGetUserById(it1.status, it1.data, it1.throwable)
            }
        })
    }

    private fun handlerGetUserById(status: ResourceState, data: UserDataView?, throwable: Throwable?) {
        when(status){
            ResourceState.LOADING ->  (activity as BaseActivity).setupScreenForLoadingState()
            ResourceState.SUCCESS -> setupScreenForUser(data)
            ResourceState.ERROR -> (activity as BaseActivity).handlerError(throwable!!)
        }
    }

    private fun setupScreenForUser(data: UserDataView?) {
        if (data != null) {
            listener?.onRegisterCompleted(data)
            (activity as BaseActivity).dismissLoading()
        }
    }

    fun setupUi(){
        tvDate.text = Utils.formatStrDate(cal.time)
        tvDate.setOnClickListener {
            val datePicker = DatePickerFragment()
            datePicker.listener = object : DatePickerFragment.DatePickerCallback{
                override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
                    cal.set(p1, p2, p3)
                    tvDate.text = Utils.formatStrDate(cal.time)
                }
            }
            datePicker.show(activity!!.supportFragmentManager, "datePicker")
        }

        btnRegister.setOnClickListener {
            val userView = userViewModel.savedUser.value?.data
            val newUser = userView?.copy(birdDate = cal.time, phone = etPhone.text.toString(), isCompleted = true)

            if (userViewModel.isValid(newUser!!, UserAction.REGISTER)){
                userViewModel.registerUser(newUser)
            } else{
                var message = ""
                if(newUser.birdDate.toString().isNullOrEmpty()){
                    message += "${getString(R.string.empty_field_error, getString(R.string.birth_date))} \n"
                }

                if(newUser.phone.isNullOrEmpty()){
                    message += "${getString(R.string.empty_field_error, getString(R.string.phone_number))} \n"
                }
                (activity as BaseActivity).setupScreenForError(message)
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is RegisterTwoFragmentCallback) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    interface RegisterTwoFragmentCallback {
        fun onRegisterCompleted(userView: UserDataView)
    }

    companion object {
        @JvmStatic
        fun newInstance(email: String) =
                SecondStepRegisterFragment().apply {
                    arguments = Bundle().apply {
                        putString(EXTRA_USER_EMAIL, email)
                    }
                }
    }
}
