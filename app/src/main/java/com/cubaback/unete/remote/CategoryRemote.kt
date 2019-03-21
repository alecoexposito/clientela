package com.cubaback.unete.remote

import com.cubaback.unete.data.model.EntityCategory
import com.cubaback.unete.data.repository.category.ICategoryRemote
import com.cubaback.unete.presentation.utils.Utils
import com.cubaback.unete.remote.model.mapper.ModelCategoryMapper
import io.reactivex.Flowable
import io.reactivex.Single
import java.util.*

open class CategoryRemote(private val joinUsService: IJoinUsService,
                          private val modelCategoryMapper: ModelCategoryMapper) : ICategoryRemote {

    override fun getCategories(): Flowable<List<EntityCategory>> {
        return joinUsService.getCategories("Bearer ${Utils.token}").map {
            val cats = mutableListOf<EntityCategory>()
            it.forEach { cats.add(modelCategoryMapper.map(it)) }
            cats
        }
    }

    override fun getCategoryById(id: Long): Single<EntityCategory> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hasChanged(date: Date): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}