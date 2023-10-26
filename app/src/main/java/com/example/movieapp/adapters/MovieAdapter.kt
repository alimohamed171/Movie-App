package com.example.movieapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.models.MovieModel
import com.example.movieapp.models.Result

class MovieAdapter(

) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

     lateinit var movies : MovieModel


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        )
    }

    override fun getItemCount(): Int = movies.results.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies.results.get(position))
    }





    class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view){

        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        lateinit var title: TextView
        lateinit var vote: TextView
        lateinit var details: TextView
        lateinit var poster: ImageView


        fun bindMovie(movie : Result){
            title = itemView.findViewById(R.id.movie_title)
            vote = itemView.findViewById(R.id.movie_release_date)
            details = itemView.findViewById(R.id.details)
            poster = itemView.findViewById(R.id.movie_poster)
            title.text = movie.title
            vote.text = movie.vote_average.toString()
            details.text=movie.overview
           // itemView.movie_release_date.text = movie.release
            Glide.with(itemView).load(IMAGE_BASE + movie.poster_path)
                .into(poster)



        }




    }





}