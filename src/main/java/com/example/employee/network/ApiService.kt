package com.example.employee.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {
companion object{

    private val BASE_URL: String="http://www.mocky.io/"

    fun client(): ServiceApiInterface {
        var client= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(getGsonFactory())
            .build().create(ServiceApiInterface::class.java)
        return client
    }

   fun getGsonFactory(): GsonConverterFactory {
       val gson = GsonBuilder()
           .create()
       return GsonConverterFactory.create(gson)
   }

}
}
