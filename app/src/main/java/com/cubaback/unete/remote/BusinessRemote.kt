package com.cubaback.unete.remote

import com.cubaback.unete.data.model.EntityBusiness
import com.cubaback.unete.data.repository.business.IBusinessRemote
import com.cubaback.unete.presentation.utils.Utils
import com.cubaback.unete.remote.model.mapper.ModelBusinessMapper
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.HttpException
import java.io.IOException
import java.util.*

open class BusinessRemote ( private val joinService: IJoinUsService,
                            private val businessModelBusinessMapper: ModelBusinessMapper): IBusinessRemote {

    override fun getBusinesses(): Flowable<List<EntityBusiness>> {
        return joinService.getBusinesses("Bearer ${Utils.token}")
                .map {
                    val bsns = mutableListOf<EntityBusiness>()
                    it.forEach{bsns.add(businessModelBusinessMapper.map(it))}
                    bsns
                }

    }

    override fun getBusinessById(id: Long): Single<EntityBusiness> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hasChanged(date: Date): Boolean {
        return try{
            val response = joinService.businessesHasChanged("Bearer ${Utils.token}", Utils.formatStrDateTime(date)).execute()
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