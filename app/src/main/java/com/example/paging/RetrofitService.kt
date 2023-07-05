package com.example.paging

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    var retrofit  = Retrofit.Builder().baseUrl("https://pixabay.com/").addConverterFactory(
        GsonConverterFactory.create()).build()

    var api = retrofit.create(PixaApi::class.java)
}