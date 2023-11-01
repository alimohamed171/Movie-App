package com.example.movieapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.movieapp.databinding.ActivityDetailsBinding
import com.example.movieapp.data.models.IMAGE_BASE
import com.example.movieapp.data.models.MovieModel
import com.example.movieapp.data.models._movies
import com.example.movieapp.data.models.genreList

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding:ActivityDetailsBinding
    private lateinit var selectedGenres : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val position = intent.getIntExtra("position",0)


        mapGenres(position)
        initUI(position)
    }



    private fun mapGenres(position:Int){

         val genreIds = _movies[position].genre_ids
         selectedGenres = genreList
            .filter { it.id in genreIds }
            .map { it.name }
            .joinToString(" ")

    }

    private fun initUI(position:Int){
        binding.textView2.text = _movies.get(position).title
        binding.txtLang.text = _movies.get(position).original_language.uppercase()
        binding.txtDetails.text = _movies.get(position).overview
        binding.txtVote.text = _movies.get(position).vote_average.toString()
        Glide.with(this)
            .load(IMAGE_BASE + _movies.get(position).poster_path)
            .into(binding.moviePoster)
        binding.txtVoteCount.text = selectedGenres


    }




}