package com.cubaback.unete

import android.app.Application
import androidx.room.Room
import com.cubaback.unete.cache.*
import com.cubaback.unete.cache.db.JoinUsDatabase
import com.cubaback.unete.cache.model.mapper.*
import com.cubaback.unete.data.model.mapper.*
import com.cubaback.unete.data.repository.domain_repository_impl.BusinessDataRepository
import com.cubaback.unete.data.repository.domain_repository_impl.UserDataRepository
import com.cubaback.unete.data.sources.business.*
import com.cubaback.unete.domain.executor.PostExecutionThread
import com.cubaback.unete.domain.executor.ThreadExecutor
import com.cubaback.unete.domain.interactor.user.LoginUC
import com.cubaback.unete.domain.repository.IBusinessRepository
import com.cubaback.unete.domain.repository.IUserRepository
import com.cubaback.unete.presentation.model.mapper.*
import com.cubaback.unete.presentation.view_model.UserViewModel
import com.cubaback.unete.data.executor.JobExecutor
import com.cubaback.unete.data.repository.advertisement.IAdvertisementCache
import com.cubaback.unete.data.repository.advertisement.IAdvertisementRemote
import com.cubaback.unete.data.repository.business.IBusinessCache
import com.cubaback.unete.data.repository.business.IBusinessRemote
import com.cubaback.unete.data.repository.category.ICategoryCache
import com.cubaback.unete.data.repository.category.ICategoryRemote
import com.cubaback.unete.data.repository.domain_repository_impl.AdvertisementDataRepository
import com.cubaback.unete.data.repository.domain_repository_impl.CategoryDataRepository
import com.cubaback.unete.data.repository.user.IUserCache
import com.cubaback.unete.data.repository.user.IUserRemote
import com.cubaback.unete.data.sources.advertisement.AdvertisementCacheDataStore
import com.cubaback.unete.data.sources.advertisement.AdvertisementDataStoreFactory
import com.cubaback.unete.data.sources.advertisement.AdvertisementRemoteDataStore
import com.cubaback.unete.data.sources.category.CategoryCacheDataStore
import com.cubaback.unete.data.sources.category.CategoryDataStoreFactory
import com.cubaback.unete.data.sources.category.CategoryRemoteDataStore
import com.cubaback.unete.data.sources.user.UserCacheDataStore
import com.cubaback.unete.data.sources.user.UserDataStoreFactory
import com.cubaback.unete.data.sources.user.UserRemoteDataStore
import com.cubaback.unete.domain.interactor.advertisement.GetAdvertisementsUC
import com.cubaback.unete.domain.interactor.business.GetBusinessesUC
import com.cubaback.unete.domain.interactor.category.GetCategoriesUC
import com.cubaback.unete.domain.interactor.user.RegisterUC
import com.cubaback.unete.domain.model.mapper.*
import com.cubaback.unete.domain.repository.IAdvertisementRepository
import com.cubaback.unete.domain.repository.ICategoryRepository
import org.buffer.android.boilerplate.remote.JoinUsServiceFactory
import com.cubaback.unete.presentation.ui.UiThread
import com.cubaback.unete.presentation.view_model.AdvertisementViewModel
import com.cubaback.unete.presentation.view_model.BusinessViewModel
import com.cubaback.unete.presentation.view_model.CategoryViewModel
import com.cubaback.unete.remote.AdvertisementRemote
import com.cubaback.unete.remote.BusinessRemote
import com.cubaback.unete.remote.CategoryRemote
import com.cubaback.unete.remote.UserRemote
import com.cubaback.unete.remote.model.mapper.*
import org.koin.android.ext.android.startKoin
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

class JoinUsApplication : Application(){

    // todo: Dividir los modulos...
    val appModule : Module = module {

        // user data stores
        factory<IUserCache> { UserCache(get(), get(), get()) }
        factory<IUserRemote> { UserRemote(get(), get()) }
        factory { UserRemoteDataStore(get()) }
        factory { UserCacheDataStore(get()) }


        // business data stores
        factory<IBusinessRemote> { BusinessRemote(get(), get()) }
        factory<IBusinessCache> { BusinessCache(get(), get(), get()) }
        factory { BusinessRemoteDataStore(get()) }
        factory { BusinessCacheDataStore(get()) }

        // category data stores
        factory<ICategoryRemote> { CategoryRemote(get(), get()) }
        factory<ICategoryCache> { CategoryCache(get(), get(), get()) }
        factory { CategoryRemoteDataStore(get()) }
        factory { CategoryCacheDataStore(get()) }


        // advertisements data stores
        factory<IAdvertisementRemote> { AdvertisementRemote(get(), get()) }
        factory<IAdvertisementCache> { AdvertisementCache(get(), get(), get()) }
        factory { AdvertisementRemoteDataStore(get()) }
        factory { AdvertisementCacheDataStore(get()) }


        // data stores factories
        factory { UserDataStoreFactory(get(), get(), get()) }
        factory { BusinessDataStoreFactory(get(), get(), get()) }
        factory { CategoryDataStoreFactory(get(), get(), get()) }
        factory { AdvertisementDataStoreFactory(get(), get(), get(), get()) }


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
        factory{ EntityAdvertisementMapper() }

        // data mappers domain
        factory{ BusinessAccountBoMapper() }
        factory{ BusinessBoMapper() }
        factory{ CategoryBoMapper() }
        factory{ ClientAccountBoMapper() }
        factory{ ClientBoMapper() }
        factory{ DependenceBoMapper() }
        factory{ ProdServsBoMapper() }
        factory{ TransactionBoMapper() }
        factory{ UserBoMapper() }
        factory{ AdvertisementBoMapper() }

        // data mappers remote...
        factory{ ModelBusinessAccountMapper() }
        factory{ ModelBusinessMapper() }
        factory{ ModelCategoryMapper() }
        factory{ ModelClientAccountMapper() }
        factory{ ModelClientMapper() }
        factory{ ModelDependenceMapper() }
        factory{ ModelProdServsMapper() }
        factory{ ModelTransactionMapper() }
        factory{ ModelUserMapper() }
        factory{ ModelAdvertisementMapper() }


        // data mappers presentation...
        factory{ BusinessAccountViewMapper() }
        factory{ BusinessViewMapper() }
        factory{ CategoryViewMapper() }
        factory{ ClientAccountViewMapper() }
        factory{ ClientViewMapper() }
        factory{ DependencesViewMapper() }
        factory{ ProdServsViewMapper() }
        factory{ TransactionViewMapper() }
        factory{ UserViewMapper() }
        factory{ AdvertisementViewMapper() }


        // data mappers cache...
        factory{ CachedBusinessAccountMapper() }
        factory{ CachedBusinessMapper() }
        factory{ CachedCategoryMapper() }
        factory{ CachedClientAccountMapper() }
        factory{ CachedClientMapper() }
        factory{ CachedDependenceMapper() }
        factory{ CachedProdServsMapper() }
        factory{ CachedTransactionMapper() }
        factory{ CachedUserMapper() }
        factory{ CachedAdvertisementMapper() }

        //preferences...
        //factory <Context>{this@JoinUsApplication}
        factory { PreferencesHelper(get()) }

        // retrofit...
        factory { JoinUsServiceFactory.makeBuffeoorService(BuildConfig.DEBUG) }


        //repositories
        single<IBusinessRepository>{BusinessDataRepository(get(), get())}
        single<IUserRepository>{UserDataRepository(get(), get())}
        single<ICategoryRepository>{ CategoryDataRepository(get(), get()) }
        single<IAdvertisementRepository>{ AdvertisementDataRepository(get(), get()) }

        // executors...
        factory<ThreadExecutor> { JobExecutor() }
        factory<PostExecutionThread> { UiThread() }

        //uses cases
        factory { LoginUC(get(), get(), get()) }
        factory { RegisterUC(get(), get(), get()) }
        factory { GetBusinessesUC(get(), get(), get()) }
        factory { GetCategoriesUC(get(), get(), get()) }
        factory { GetAdvertisementsUC(get(), get(), get()) }


        // Room Database
        single{
            Room.databaseBuilder(androidApplication(), JoinUsDatabase::class.java, "joinusdb")
                    .fallbackToDestructiveMigration()
                    .build()
        }

        // Database DAo
        single { get<JoinUsDatabase>().cachedUserDao() }
        single { get<JoinUsDatabase>().cachedBusinessDao() }
        single { get<JoinUsDatabase>().cachedCategoryDao() }
        single { get<JoinUsDatabase>().cachedAdvertisementDao() }

        // view models
        viewModel{ UserViewModel(get(), get(), get())}
        viewModel{ BusinessViewModel(get(), get())}
        viewModel{ CategoryViewModel(get(), get()) }
        viewModel{ AdvertisementViewModel(get(), get()) }



    }


    override fun onCreate() {
        super.onCreate()

        // initialize koin
       startKoin(this, listOf(appModule))
    }
}

