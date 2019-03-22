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
    fun login(@Body userView: UserModel) : Single<UserModel>


    @Headers("Content-Type:application/json")
    @POST("auth/register")
    fun register(@Body userModel: UserModel) : Single<UserModel>




    /************************************************************************************
     *                                      Businesses
     * ***********************************************************************************/

    @Headers("Content-Type:application/json")
    @GET("business")
    fun getBusinesses(@Header("Authorization") token: String ) : Flowable<List<BusinessModel>>

    @Headers("Content-Type:application/json")
    @POST("business/has-changed")
    fun businessesHasChanged(@Header("Authorization") token: String,  @Field("updated_at") date : Date  ) : Single<HasChangedModel>




    /************************************************************************************
     *                                      Categories
     * ***********************************************************************************/

    @Headers("Content-Type:application/json")
    @GET("business-category")
    fun getCategories(@Header("Authorization") token: String ) : Flowable<List<CategoryModel>>

    @Headers("Content-Type:application/json")
    @POST("business-category/has-changed")
    fun categoriesHasChanged(@Header("Authorization") token: String,  @Field("updated_at") date : Date  ) : Single<HasChangedModel>



    /************************************************************************************
     *                                      Advertisements
     * ***********************************************************************************/

    @Headers("Content-Type:application/json")
    @GET("advertisement")
    fun getAdvertisement(@Header("Authorization") token: String ) : Flowable<List<AdvertisementModel>>

    @Headers("Content-Type:application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("advertisement/has-changed")
    fun advertisementsHasChanged(@Header("Authorization") token: String, @Field("updated_at") date : Date ) : Call<HasChangedModel>



}