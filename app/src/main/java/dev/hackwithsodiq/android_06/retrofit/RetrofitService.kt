package dev.hackwithsodiq.android_06.retrofit

import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {
    @GET("users/{user}/repos")
    suspend fun listRepos(@Path("user") user:String):List<RepoResponse>?
}