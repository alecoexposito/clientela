package com.cubaback.unete.remote

import com.cubaback.unete.data.model.EntityAdvertisements
import com.cubaback.unete.data.repository.advertisement.IAdvertisementRemote
import com.cubaback.unete.presentation.untils.Utils
import com.cubaback.unete.remote.model.AdvertisementModel
import com.cubaback.unete.remote.model.mapper.ModelAdvertisementMapper
import io.reactivex.Flowable
import io.reactivex.Single

class AdvertisementRemote(private val joinUsService: IJoinUsService,
                          private val modelAdvertisementMapper: ModelAdvertisementMapper) : IAdvertisementRemote {

    override fun getAdvertisements(): Flowable<List<EntityAdvertisements>> {
         return joinUsService.getAdvertisement("Bearer ${Utils.token}")
                 .map {
                     val advs = mutableListOf<EntityAdvertisements>()
                     it.forEach { advs.add(modelAdvertisementMapper.map(it)) }
                     advs
                 }
    }

    override fun getAdvertisementById(id: Long): Single<EntityAdvertisements> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}