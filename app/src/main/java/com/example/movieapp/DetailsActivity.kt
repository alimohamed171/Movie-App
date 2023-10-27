package com.example.movieapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.movieapp.databinding.ActivityDetailsBinding
import com.example.movieapp.models.IMAGE_BASE
import com.example.movieapp.models.MovieModel
import com.example.movieapp.models._movies

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

    val postion = intent.getIntExtra("postion",0)



        binding.textView2.text = _movies.get(postion).title
        binding.txtLang.text = _movies.get(postion).original_language.uppercase()
        binding.txtDetails.text = _movies.get(postion).overview
        binding.txtVote.text = _movies.get(postion).vote_average.toString()
        binding.txtVoteCount.text = _movies.get(postion).vote_count.toString()
        Glide.with(this)
            .load(IMAGE_BASE + _movies.get(postion).poster_path)
            .into(binding.moviePoster)





    }









}