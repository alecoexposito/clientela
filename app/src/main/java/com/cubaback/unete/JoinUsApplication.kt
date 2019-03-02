package com.cubaback.unete

import android.app.Application
import com.cubaback.unete.data.model.mapper.*
import com.cubaback.unete.data.repository.IBusinessDataStore
import com.cubaback.unete.data.repository.impl.BusinessDataRepository
import com.cubaback.unete.data.sources.business.BusinessCacheDataStore
import com.cubaback.unete.data.sources.business.BusinessDataStoreFactory
import com.cubaback.unete.data.sources.business.BusinessRemoteDataStore
import com.cubaback.unete.domain.repository.IBusinessRepository
import org.buffer.android.boilerplate.data.mapper.Mapper
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

class JoinUsApplication : Application(){

    val appModule : Module = module {


        single<IBusinessDataStore>(name = "BusinessRemoteDataStore") { BusinessRemoteDataStore(get()) }
        single<IBusinessRepository> {BusinessDataRepository(get(), get()) }
        single<IBusinessDataStore>(name = "BusinessCacheDataStore") { BusinessCacheDataStore(get()) }
        single<IBusinessDataStore>(name = "BusinessCacheDataStore") { BusinessCacheDataStore(get()) }

        // data mappers...
        factory{ EntityBusinessAccountMapper() }
        factory{ EntityBusinessMapper() }
        factory{ EntityCategoryMapper() }
        factory{ EntityClientAccountMapper() }
        factory{ EntityClientMapper() }
        factory{ EntityDependenceMapper() }
        factory{ EntityProdServsMapper() }
        factory{ EntityTransactionMapper() }
        factory{ EntityUserMapper() }

        //repositories
        factory { BusinessDataStoreFactory(get(), get(), get()) }
    }


    override fun onCreate() {
        super.onCreate()

        // initialize koin
       startKoin(this, listOf(appModule))
    }
}

