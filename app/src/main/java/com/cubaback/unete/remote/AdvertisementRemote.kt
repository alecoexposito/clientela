package com.cubaback.unete.remote

import com.cubaback.unete.data.model.EntityAdvertisements
import com.cubaback.unete.data.repository.advertisement.IAdvertisementRemote
import com.cubaback.unete.presentation.utils.Utils
import com.cubaback.unete.remote.model.HasChangedModel
import com.cubaback.unete.remote.model.mapper.ModelAdvertisementMapper
import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.functions.Consumer
import io.reactivex.internal.operators.single.SingleDoOnSuccess
import io.reactivex.rxkotlin.toSingle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

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

    // Todo: Hacer esto mas bonito...
    override fun hasChanged(date: Date): Boolean {
        return try{
            val formatD = "yyyy-MM-dd HH:mm:ss"
            val dateFormat = SimpleDateFormat(formatD, Locale.getDefault())
            var dateStr = dateFormat.format(date)
            var dateDate = dateFormat.parse(dateStr)

            var response = joinUsService.advertisementsHasChanged("Bearer ${Utils.token}", dateDate).execute().body()
            if(response != null){
                response.hasChanged
            } else{
                false
            }
        } catch (e : IOException){
            false
        }
    }
}


