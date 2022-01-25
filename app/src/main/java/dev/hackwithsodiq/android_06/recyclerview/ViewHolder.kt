package dev.hackwithsodiq.android_06.recyclerview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.hackwithsodiq.android_06.R

class ViewHolder(view:View) : RecyclerView.ViewHolder(view) {
    val userImage = view.findViewById<ImageView>(R.id.img_profile)
    val repoName = view.findViewById<TextView>(R.id.txt_repo_name)
    val repoUserName = view.findViewById<TextView>(R.id.txt_repo_username)
}