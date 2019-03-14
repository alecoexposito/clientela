package com.cubaback.unete.data.repository.category

import com.cubaback.unete.data.model.EntityCategory
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Repositorio de negocios para interactuar con el API
 * */
interface ICategoryRemote {

    /**
     * Retorna la lista de categorias
     * */
    fun getCategories() : Flowable<List<EntityCategory>>

    /**
     * Retorna un negocio dado el Id
     * */
    fun getCategoryById(id : Long): Single<EntityCategory>

}