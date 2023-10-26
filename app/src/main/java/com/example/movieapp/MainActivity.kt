package com.example.movieapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.movieapp.adapters.MovieAdapter
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.models.MovieModel
import com.example.movieapp.models.Result
import com.example.movieapp.network.ApiCalls
import com.example.movieapp.network.RetroConnection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var _movies : List<Result>


    val adapter: MovieAdapter = MovieAdapter{ position: Int ->


        val intent = Intent(this, DetailsActivity::class.java)

        intent.putExtra("title",_movies.get(position).title)
        intent.putExtra("overview",_movies.get(position).overview)
        intent.putExtra("voteCount",_movies.get(position).vote_count)
        intent.putExtra("language",_movies.get(position).original_language)
        intent.putExtra("voteAverage",_movies.get(position).vote_average)
        intent.putExtra("posterPath",_movies.get(position).poster_path )


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



    }


    private fun getMovieData(callback: (MovieModel) -> Unit){

        val apiService = RetroConnection.retrofit.create(ApiCalls::class.java)
        apiService.getMovie().enqueue(object : Callback<MovieModel> {
            override fun onFailure(call: Call<MovieModel>, t: Throwable) {

            }

            override fun onResponse(call: Call<MovieModel>, response: Response<MovieModel>) {
                return callback(response.body()!!)
            }

        })
    }

}




//rv_movies_list.layoutManager = LinearLayoutManager(this)
//rv_movies_list.setHasFixedSize(true)
//getMovieData { movies : List<Movie> ->
//    rv_movies_list.adapter = MovieAdapter(movies)
//}
//}
//
//private fun getMovieData(callback: (List<Movie>) -> Unit){
//    val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
//    apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
//        override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
//
//        }
//
//        override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
//            return callback(response.body()!!.movies)
//        }
//
//    })
//}