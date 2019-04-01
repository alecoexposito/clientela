package com.cubaback.unete.remote

import com.cubaback.unete.remote.model.*
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.*
import java.util.*

interface IJoinUsService {

    /************************************************************************************
     *                                      Users
     * **********************************************************************************/

    @Headers("Content-Type:application/json")
    @POST("auth/login")
    fun login(@Body userView: UserModel) : Single<ClientResponse>


    @Headers("Content-Type:application/json")
    @POST("auth/register")
    fun register(@Body userModel: UserModel) : Single<ClientResponse>




    /************************************************************************************
     *                                      Businesses
     * ***********************************************************************************/

    @Headers("Content-Type:application/json")
    @GET("business")
    fun getBusinesses(@Header("Authorization") token: String ) : Flowable<List<BusinessModel>>

    @Headers("Content-Type:application/json")
    @GET("business/has-changed")
    fun businessesHasChanged(@Header("Authorization") token: String,  @Query("updated_at") date : String  ) : Call<HasChangedModel>




    /************************************************************************************
     *                                      Categories
     * ***********************************************************************************/

    @Headers("Content-Type:application/json")
    @GET("business-category")
    fun getCategories(@Header("Authorization") token: String ) : Flowable<List<CategoryModel>>

    @Headers("Content-Type:application/json")
    @GET("business-category/has-changed")
    fun categoriesHasChanged(@Header("Authorization") token: String,  @Query("updated_at") date : String  ) : Call<HasChangedModel>



    /************************************************************************************
     *                                      Advertisements
     * ***********************************************************************************/

    @Headers("Content-Type:application/json")
    @GET("advertisement")
    fun getAdvertisement(@Header("Authorization") token: String ) : Flowable<List<AdvertisementModel>>

    @Headers("Content-Type:application/x-www-form-urlencoded")
    @GET("advertisement/has-changed")
    fun advertisementsHasChanged(@Header("Authorization") token: String, @Query("updated_at")  date : String ) : Call<HasChangedModel>



}