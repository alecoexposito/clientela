package com.cubaback.unete.remote

import com.cubaback.unete.data.model.EntityBusiness
import com.cubaback.unete.data.repository.business.IBusinessRemote
import com.cubaback.unete.presentation.untils.Utils
import com.cubaback.unete.remote.model.mapper.ModelBusinessMapper
import io.reactivex.Flowable
import io.reactivex.Single

open class BusinessRemote ( private val joinService: IJoinUsService,
                            private val businessModelBusinessMapper: ModelBusinessMapper): IBusinessRemote {

    override fun getBusinesses(): Flowable<List<EntityBusiness>> {
        return joinService.getBusinesses("Bearer $Utils.token")
                .map {
                    val bsns = mutableListOf<EntityBusiness>()
                    it.forEach{bsns.add(businessModelBusinessMapper.map(it))}
                    bsns
                }

    }

    override fun getBusinessById(id: Long): Single<EntityBusiness> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}