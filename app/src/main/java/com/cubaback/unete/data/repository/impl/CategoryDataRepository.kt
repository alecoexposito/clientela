package com.cubaback.unete.data.repository.impl

import com.cubaback.unete.data.model.EntityCategory
import com.cubaback.unete.data.model.mapper.EntityCategoryMapper
import com.cubaback.unete.data.sources.category.CategoryDataStoreFactory
import com.cubaback.unete.domain.model.CategoryBo
import com.cubaback.unete.domain.repository.ICategoryRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

open class CategoryDataRepository(private val factory : CategoryDataStoreFactory,
                                  private val categoryEntityMapper : EntityCategoryMapper) : ICategoryRepository {

    override fun clearCategories(): Completable {
        return factory.retrieveCacheDataStore().clearCategories()
    }

    override fun saveCategories(categories: List<CategoryBo>): Completable {
        val categoriesEntities = mutableListOf<EntityCategory>()
        categories.map { categoriesEntities.add(categoryEntityMapper.reverseMap(it)) }
        return factory.retrieveCacheDataStore().saveCategories(categoriesEntities)
    }

    override fun getCategories(): Flowable<List<CategoryBo>> {
        return factory.categoryCacheDataStore.isCached()
                .flatMapPublisher {
                    factory.retrieveDataStore(it).getCategories()
                }
                .flatMap {
                    Flowable.just(it.map { categoryEntityMapper.map(it) })
                }
//                .flatMap {
//                    saveCategories(it).toSingle{it}.toFlowable()
//                }
    }

    override fun getCategoryById(id: Long): Single<CategoryBo> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}