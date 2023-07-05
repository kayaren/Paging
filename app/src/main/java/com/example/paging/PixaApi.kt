package com.example.paging

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixaApi {
    @GET("api/")
    fun searchImage(
        @Query("key") key :String,
        @Query("q") searchWord : String = "38085868-c8c559468514cd4044db32756"
    ) : Call<PixaModel>
}