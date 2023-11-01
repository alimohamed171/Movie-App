package com.example.movieapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.movieapp.adapters.MovieAdapter
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.data.models.Genre
import com.example.movieapp.data.models.GenreModel
import com.example.movieapp.data.models.MovieModel
import com.example.movieapp.data.models.Result
import com.example.movieapp.data.models._movies
import com.example.movieapp.data.models.genreList
import com.example.movieapp.data.network.ApiCalls
import com.example.movieapp.data.network.RetroConnection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding




    val apiService = RetroConnection.retrofit.create(ApiCalls::class.java)

    val adapter: MovieAdapter = MovieAdapter{ position: Int ->
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("position",position)
        startActivity(intent)

    }





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        getMovieData { movies : MovieModel ->

            _movies = movies.results
            adapter.movies = movies.results
            binding.rvMoviesList.adapter = adapter
        }
        getGenres {
            genreList = it.genres

        }



    }


    private fun getMovieData(callback: (MovieModel) -> Unit){

        binding.progressBar.visibility = View.VISIBLE

        apiService.getMovie().enqueue(object : Callback<MovieModel> {
            override fun onFailure(call: Call<MovieModel>, t: Throwable) {

            }

            override fun onResponse(call: Call<MovieModel>, response: Response<MovieModel>) {
                binding.progressBar.visibility = View.GONE
                return callback(response.body()!!)
            }

        })
    }


    private fun getGenres(callback: (GenreModel) -> Unit){

        apiService.getGenre().enqueue(object : Callback<GenreModel>{
            override fun onResponse(call: Call<GenreModel>, response: Response<GenreModel>) {
                return callback(response.body()!!)
            }

            override fun onFailure(call: Call<GenreModel>, t: Throwable) {
                  Toast.makeText(applicationContext,"failed",Toast.LENGTH_LONG).show()
            }


        })
    }









}




