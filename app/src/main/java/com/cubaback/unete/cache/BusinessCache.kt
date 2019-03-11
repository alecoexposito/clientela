package com.cubaback.unete.cache

import com.cubaback.unete.data.model.EntityBusiness
import com.cubaback.unete.data.repository.business.IBusinessCache
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

class BusinessCache : IBusinessCache {
    override fun clearBusinesses(): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveBusinesses(businesses: List<EntityBusiness>): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBusinesses(): Flowable<List<EntityBusiness>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isCached(): Single<Boolean> {
        // todo: cambiar cuando este la base de datos...
        return Single.defer { Single.just(false) }
    }

    override fun setLastCacheTime(lastCache: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isExpired(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBusinessById(id: Long): Single<EntityBusiness> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}