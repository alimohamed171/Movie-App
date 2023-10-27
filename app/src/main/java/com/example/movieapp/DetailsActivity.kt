package com.example.movieapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.movieapp.databinding.ActivityDetailsBinding
import com.example.movieapp.models.IMAGE_BASE
import com.example.movieapp.models.MovieModel

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

    val title = intent.getStringExtra("title")
    val overview = intent.getStringExtra("overview")
    val voteCount = intent.getIntExtra("voteCount", 0)
    val language = intent.getStringExtra("language")
    val voteAverage = intent.getDoubleExtra("voteAverage", 0.0)
    val posterPath = intent.getStringExtra("posterPath")


        binding.textView2.text = title
        Glide.with(this)
            .load(IMAGE_BASE + posterPath)
            .into(binding.moviePoster)
        binding.txtLang.text = language?.uppercase()
        binding.txtDetails.text = overview
        binding.txtVote.text = voteAverage.toString()
        binding.txtVoteCount.text = voteCount.toString()






    }









}