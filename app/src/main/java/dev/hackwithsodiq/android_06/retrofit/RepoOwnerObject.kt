package dev.hackwithsodiq.android_06.retrofit

import com.google.gson.annotations.SerializedName

data class RepoOwnerObject(
    @SerializedName("avatar_url")
    var profileImage:String
)