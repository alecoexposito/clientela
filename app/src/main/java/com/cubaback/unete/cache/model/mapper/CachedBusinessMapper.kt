package com.cubaback.unete.cache.model.mapper

import com.cubaback.unete.domain.model.BusinessBo
import com.cubaback.unete.cache.model.CachedBusiness
import com.cubaback.unete.cache.model.CachedCategory
import com.cubaback.unete.cache.model.CachedDependences
import com.cubaback.unete.data.model.EntityBusiness
import com.cubaback.unete.mapper.Mapper
import io.realm.RealmList

open class CachedBusinessMapper(private val cachedCategoryMapper: CachedCategoryMapper,
                                private val cachedDependenceMapper: CachedDependenceMapper) : Mapper<EntityBusiness, CachedBusiness>() {



    override fun map(type: EntityBusiness): CachedBusiness {

        return CachedBusiness(type.id, type.name, type.description, type.image,
                type.dependence?.let {
                    var realmListDependence  = RealmList<CachedDependences>()
                    realmListDependence.addAll(cachedDependenceMapper.map(it))
                    realmListDependence
                },
                type.categories?.let {
                    var realmList  = RealmList<CachedCategory>()
                    realmList.addAll(cachedCategoryMapper.map(it))
                     realmList
                })
    }

    override fun reverseMap(type: CachedBusiness): EntityBusiness {
        return EntityBusiness(type.id, type.name, type.description,
                type.image,
                type.dependence?.let { cachedDependenceMapper.reverseMap(it) },
                type.categories?.let {  cachedCategoryMapper.reverseMap(it) })
    }
}