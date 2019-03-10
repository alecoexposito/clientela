package com.cubaback.unete.data.repository.business

import com.cubaback.unete.data.model.EntityBusiness
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Repositorio de negocios para interactuar con el API
 * */
interface IBusinessRemote {

    /**
     * Retorna la lista de negocios
     * */
    fun getBusinesses() : Flowable<List<EntityBusiness>>

    /**
     * Retorna un negocio dado el Id
     * */
    fun getBusinessById(id : Long): Single<EntityBusiness>

}