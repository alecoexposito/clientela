package com.cubaback.unete.data.repository.category

import com.cubaback.unete.data.model.EntityCategory
import io.reactivex.Flowable
import io.reactivex.Single
import java.util.*

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


    fun hasChanged(date : Date) : Boolean

}