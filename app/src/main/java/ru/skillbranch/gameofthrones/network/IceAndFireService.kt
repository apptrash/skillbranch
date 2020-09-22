package ru.skillbranch.gameofthrones.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.skillbranch.gameofthrones.AppConfig
import ru.skillbranch.gameofthrones.data.remote.res.CharacterRes
import ru.skillbranch.gameofthrones.data.remote.res.HouseRes

interface IceAndFireApi {
    @GET("houses?pageSize=50")
    suspend fun getHouses(@Query("page") page: Int = 1): List<HouseRes>

    @GET("characters/{id}")
    suspend fun getCharacter(@Path("id") characterId: String): CharacterRes

    @GET("houses")
    suspend fun getHouseByName(@Query("name") name: String) : List<HouseRes>
}

object IceAndFireService {
    val api: IceAndFireApi by lazy {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(AppConfig.BASE_URL)
            .build()
        retrofit.create(IceAndFireApi::class.java)
    }
}