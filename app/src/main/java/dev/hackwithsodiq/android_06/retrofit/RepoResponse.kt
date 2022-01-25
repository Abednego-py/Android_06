package dev.hackwithsodiq.android_06.retrofit

data class RepoResponse(
    var name:String,
    var description:String,
    var owner:RepoOwnerObject
)