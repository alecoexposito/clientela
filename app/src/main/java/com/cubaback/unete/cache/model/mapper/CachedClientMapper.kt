package com.cubaback.unete.cache.model.mapper

import com.cubaback.unete.cache.model.CachedClient
import com.cubaback.unete.data.model.EntityClient
import com.cubaback.unete.mapper.Mapper

open class CachedClientMapper(val cachedUserMapper: CachedUserMapper,
                              val cachedClientAccountMapper: CachedClientAccountMapper): Mapper<EntityClient, CachedClient>() {

    override fun map(type: EntityClient): CachedClient {
        return CachedClient(type.id, type.phone, type.birthDate, type.createdAt, type.updatedAt,
                type.user?.let { cachedUserMapper.map(it) },
                type.account?.let { cachedClientAccountMapper.map(it) })
    }

    override fun reverseMap(type: CachedClient): EntityClient {
        return EntityClient(type.id, type.phone, type.birthDate, type.createdAt, type.updatedAt,
                type.user?.let { cachedUserMapper.reverseMap(it) },
                type.account?.let { cachedClientAccountMapper.reverseMap(it) })
    }
}
