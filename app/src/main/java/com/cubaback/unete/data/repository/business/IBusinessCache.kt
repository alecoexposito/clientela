package com.cubaback.unete.data.repository.business

import com.cubaback.unete.data.model.EntityBusiness
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

interface IBusinessCache {

    /**
     * Limpia la lista de negocios de la cache
     * */
    fun clearBusinesses() : Completable

    /**
     * Guarda la lista de negocios en la cache
     * **/
    fun saveBusinesses(businesses : List<EntityBusiness>) : Completable

    /**
     * Optiene la lista de negocios de la cache
     * */
    fun getBusinesses() : Flowable<List<EntityBusiness>>

    /**
     * Checkea que la lista de negocios esta en cache
     * retorna true si esta en cache
     * */
    fun isCached() : Single<Boolean>

    /**
     * Cambia la fecha de la ultima cache
     * */
    fun setLastCacheTime(lastCache : Long)


    fun getLastCacheTime() : Long

    /**
     * Verifica que la cache no halla expirado
     * retorna true, si la cache ha espirado, de lo contrario retorna false
     * */
    fun isExpired() : Boolean

    fun getBusinessById(id : Long): Single<EntityBusiness>

}