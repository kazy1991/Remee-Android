package com.github.kazy1991.remee.adapter


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import com.github.kazy1991.remee.R
import com.github.kazy1991.twitterpack.entity.TweetEntity
import org.threeten.bp.format.DateTimeFormatter
import java.util.*

class FavoriteListAdapter : RecyclerView.Adapter<FavoriteListAdapter.ViewHolder>() {

    private val tweets = ArrayList<TweetEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.cell_favorite, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tweet = tweets[position]
        holder.textView.text = tweet.text
        holder.userIconView.setImageURI(tweet.userEntity.profileImageUrlHttps)
        holder.accountNameView.text = tweet.userEntity.name
        holder.createdAtView.text = tweet.createdAt.format(DateTimeFormatter.ofPattern("MM-dd HH:mm"))
    }

    override fun getItemCount(): Int {
        return tweets.size
    }

    fun addAll(tweets: List<TweetEntity>) {
        this.tweets.clear()
        this.tweets.addAll(tweets)
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val textView by lazy { view.findViewById(R.id.text) as TextView }
        val userIconView by lazy { view.findViewById(R.id.user_icon) as SimpleDraweeView }
        val accountNameView by lazy { view.findViewById(R.id.account_name) as TextView }
        val createdAtView by lazy { view.findViewById(R.id.created_at) as TextView }
    }
}