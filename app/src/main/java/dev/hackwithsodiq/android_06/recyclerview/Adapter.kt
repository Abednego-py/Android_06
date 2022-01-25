package dev.hackwithsodiq.android_06.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import dev.hackwithsodiq.android_06.R
import dev.hackwithsodiq.android_06.retrofit.RepoResponse

class Adapter(val items:List<RepoResponse> = emptyList(), val block:(Int)->Unit):RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.repoName.text = items[position].name
        holder.repoUserName.text = items[position].description
        holder.userImage.load(items[position].owner.profileImage){
            error(R.drawable.ic_baseline_account_circle_24)
            placeholder(R.drawable.ic_baseline_account_circle_24)
        }
        holder.itemView.setOnClickListener{
            block.invoke(position)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}