package my.company.app.mainscreen.github

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_user.view.*
import my.company.app.mainscreen.R
import my.company.app.presentation.mainscreen.githubpage.model.GithubUserView

internal class GithubUsersAdapter(private val data: List<GithubUserView>, private val listener: (GithubUserView) -> Unit)
    : RecyclerView.Adapter<GithubUsersAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false))

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position], listener)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(item: GithubUserView, listener: (GithubUserView) -> Unit) = with(itemView){
            name.text = item.login
            setOnClickListener{ listener(item) }
            Glide.with(context)
                    .load(item.avatar)
                    .into(profilePic)
        }
    }
}