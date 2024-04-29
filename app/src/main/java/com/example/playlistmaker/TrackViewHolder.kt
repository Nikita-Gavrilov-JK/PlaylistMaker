package com.example.playlistmaker

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class TrackViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val trackName: TextView = view.findViewById(R.id.track_name)
    val artistName: TextView = view.findViewById(R.id.artist_name)
    val trackTime: TextView = view.findViewById(R.id.track_time)
    val artwork: ImageView = view.findViewById(R.id.artwork)

    fun bind(track: Track) {
        trackName.text = track.trackName
        artistName.text = track.artistName
        trackTime.text = track.trackTime
        Glide.with(itemView.context).load(track.artworkUrl100).into(artwork)
    }
}
