package com.cubaback.unete.data.repository.category

import com.cubaback.unete.cache.model.CachedCategory
import com.cubaback.unete.data.model.EntityCategory
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

interface ICategoryCache {

    /**
     * Limpia la lista de categorias de la cache
     * */
    fun clearCategories() : Completable

    /**
     * Guarda la lista de categorias en la cache
     * **/
    fun saveCategories(Categories : List<EntityCategory>) : Completable

    /**
     * Optiene la lista de categorias de la cache
     * */
    fun getCategories() : Flowable<List<EntityCategory>>

    /**
     * Checkea que la lista de categorias esta en cache
     * retorna true si esta en cache
     * */
    fun isCached() : Single<Boolean>

    /**
     * Cambia la fecha de la ultima cache
     * */
    fun setLastCacheTime(lastCache : Long)

    fun getLastCacheTime() : Long


    fun getCategoriesByParentId(parentId : Long): Flowable<List<EntityCategory>>

    /**
     * Verifica que la cache no halla expirado
     * retorna true, si la cache ha espirado, de lo contrario retorna false
     * */
    fun isExpired() : Boolean

    fun getBusinessById(id : Long): Single<EntityCategory>

    fun getLastCached() : Long

}