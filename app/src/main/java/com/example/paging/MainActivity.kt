package com.example.paging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.paging.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    val adapter = PixaAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
    }

    private fun initClickers() {
        with(binding){
serarchBtn.setOnClickListener {
recyclerView.adapter = adapter
    RetrofitService.api.searchImage(searchEd.text.toString()).enqueue(object : Callback<PixaModel>{
        override fun onResponse(call: Call<PixaModel>, response: Response<PixaModel>) {
            if(response.isSuccessful){
              var data = response.body()?.hits
                adapter.addImage(data!!)

            }
        }

        override fun onFailure(call: Call<PixaModel>, t: Throwable) {

        }
    })
}
        }
    }
}


