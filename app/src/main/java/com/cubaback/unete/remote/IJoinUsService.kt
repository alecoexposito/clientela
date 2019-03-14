package com.cubaback.unete.remote

import com.cubaback.unete.remote.model.BusinessModel
import com.cubaback.unete.remote.model.CategoryModel
import com.cubaback.unete.remote.model.UserModel
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.*

interface IJoinUsService {

    /************************************************************************************
     *                                      Users
     * **********************************************************************************/

    @Headers("Content-Type:application/json")
    @POST("auth/login")
    fun login(@Body userView: UserModel) : Single<UserModel>


    @GET("auth/register")
    fun register(@Body userModel: UserModel) : Single<UserModel>


    /************************************************************************************
     *                                      Businesses
     * ***********************************************************************************/

    @Headers("Content-Type:application/json")
    @GET("business")
    fun getBusinesses(@Header("Authorization") token: String ) : Flowable<List<BusinessModel>>

    /************************************************************************************
     *                                      Categories
     * ***********************************************************************************/

    @Headers("Content-Type:application/json")
    @GET("business-category")
    fun getCategories(@Header("Authorization") token: String ) : Flowable<List<CategoryModel>>



}