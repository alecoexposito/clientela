package com.cubaback.unete.remote

import com.cubaback.unete.data.model.EntityCategory
import com.cubaback.unete.data.repository.category.ICategoryRemote
import com.cubaback.unete.presentation.utils.Utils
import com.cubaback.unete.remote.model.mapper.ModelCategoryMapper
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.HttpException
import java.io.IOException
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
        return try{
            val response = joinUsService.categoriesHasChanged("Bearer ${Utils.token}", Utils.formatStrDateTime(date)).execute()
            val code = response.code()
            if(code == 200){
                response.body()!!.hasChanged
            } else{
                if(code == 401){
                    throw HttpException(response)
                }
                false
            }
        }catch (e : IOException){
            false
        }
    }
}