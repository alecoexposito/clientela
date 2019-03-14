package com.cubaback.unete.domain.repository

import com.cubaback.unete.domain.model.CategoryBo
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

interface ICategoryRepository{

    fun clearCategories(): Completable

    fun saveCategories(businesses: List<CategoryBo>): Completable

    fun getCategories(): Flowable<List<CategoryBo>>


    fun getCategoryById(id : Long): Single<CategoryBo>
}