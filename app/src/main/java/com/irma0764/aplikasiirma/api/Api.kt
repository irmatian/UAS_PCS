package com.irma0764.aplikasiirma.api

import com.irma0764.aplikasiirma.data.model.DetailUserResponse
import com.irma0764.aplikasiirma.data.model.User
import com.irma0764.aplikasiirma.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization: token e934c504806345c57102a8b07f4da1f90da5fdc3")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization: token e934c504806345c57102a8b07f4da1f90da5fdc3")
    fun getUserDetail(
        @Path("username") username: String
    ): Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token e934c504806345c57102a8b07f4da1f90da5fdc3")
    fun getFollowers(
        @Path("username") username: String
    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token e934c504806345c57102a8b07f4da1f90da5fdc3")
    fun getFollowing(
        @Path("username") username: String
    ): Call<ArrayList<User>>
}