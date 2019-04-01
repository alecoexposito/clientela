package com.cubaback.unete.data.repository.domain_repository_impl

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
        return factory.retrieveCacheDataStore().saveCategories(categoriesEntities).doOnComplete {
            val lastTime = categories.sortedBy { it.updateAt }.last().updateAt
            lastTime?.let { factory.retrieveCacheDataStore().setLastCacheTime(it.time)  }}
    }

    override fun getCategories(): Flowable<List<CategoryBo>> {
        return factory.categoryCacheDataStore.isCached()
                .flatMapPublisher {
                    factory.retrieveDataStore(it).getCategories()
                }
                .flatMap {
                    Flowable.just(it.map { categoryEntityMapper.map(it) })
                }
                .flatMap {
                    saveCategories(it).toSingle{it}.toFlowable()
                }
    }

    override fun getCategoryById(id: Long): Single<CategoryBo> {
        return factory.categoryCacheDataStore.getCategoryById(id)
                .flatMap {
                    Single.just(categoryEntityMapper.map(it))
                }
    }

    override fun getCategoriesByParentId(parentId: Long): Flowable<List<CategoryBo>> {
        return factory.categoryCacheDataStore.getCategoriesByParentId(parentId)
                .flatMap {
                    Flowable.just( it.map { categoryEntityMapper.map(it) } )
                }
    }
}