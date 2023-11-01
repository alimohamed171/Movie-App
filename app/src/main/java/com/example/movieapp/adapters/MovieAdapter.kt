package com.example.movieapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.data.models.IMAGE_BASE
import com.example.movieapp.data.models.MovieModel
import com.example.movieapp.data.models.Result

class MovieAdapter(private val onItemClick: (position: Int) -> Unit

) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

     lateinit var movies : List<Result>


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movieeee_item, parent, false)
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies.get(position))
    }





  inner class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view){


        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(position)
                }
            }
        }


       // private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        lateinit var title: TextView
        lateinit var vote: TextView
        lateinit var details: TextView
        lateinit var poster: ImageView


        fun bindMovie(movie : Result){
            title = itemView.findViewById(R.id.movie_title)
            vote = itemView.findViewById(R.id.movie_release_date)

            poster = itemView.findViewById(R.id.movie_poster)
            title.text = movie.title
            vote.text = movie.vote_average.toString()


            Glide.with(itemView).load(IMAGE_BASE + movie.poster_path)
                .into(poster)

        }




    }





}