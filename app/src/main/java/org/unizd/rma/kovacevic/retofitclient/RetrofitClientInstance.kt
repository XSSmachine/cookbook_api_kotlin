package org.unizd.rma.kovacevic.retofitclient

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClientInstance {
    companion object {
        private const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
        val retrofitInstance: Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

}