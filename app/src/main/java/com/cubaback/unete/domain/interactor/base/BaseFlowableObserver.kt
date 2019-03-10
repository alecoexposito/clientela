package com.cubaback.unete.domain.interactor.base

import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

/**
 * Default [SingleObserver] base class to define
 */
open class BaseFlowableObserver<T> : SingleObserver<T> {

    override fun onSubscribe(d: Disposable) { }

    override fun onSuccess(t: T) { }

    override fun onError(exception: Throwable) { }

}