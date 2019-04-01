package com.cubaback.unete.remote

import com.cubaback.unete.data.model.EntityAdvertisements
import com.cubaback.unete.data.repository.advertisement.IAdvertisementRemote
import com.cubaback.unete.presentation.utils.Utils
import com.cubaback.unete.remote.model.mapper.ModelAdvertisementMapper
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.HttpException
import java.io.IOException
import java.util.*

class AdvertisementRemote(private val joinUsService: IJoinUsService,
                          private val modelAdvertisementMapper: ModelAdvertisementMapper) : IAdvertisementRemote {

    override fun getAdvertisements(): Flowable<List<EntityAdvertisements>> {
         return joinUsService.getAdvertisement("Bearer ${Utils.token}")
                 .map {
                     val advs = mutableListOf<EntityAdvertisements>()
                     it.forEach { it1->advs.add(modelAdvertisementMapper.map(it1)) }
                     advs
                 }
    }

    override fun getAdvertisementById(id: Long): Single<EntityAdvertisements> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hasChanged(date: Date): Boolean {
        return try{
            val response = joinUsService.advertisementsHasChanged("Bearer ${Utils.token}", Utils.formatStrDateTime(date)).execute()
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


