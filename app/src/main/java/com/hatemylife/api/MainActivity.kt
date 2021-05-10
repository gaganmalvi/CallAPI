package com.hatemylife.api

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var progress: ProgressDialog
    var dataList = ArrayList<Model>()
    lateinit var recyclerView: RecyclerView
    lateinit var adapter:DataAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageview = findViewById<ImageView>(R.id.imageview)
        val image = "https://raw.githubusercontent.com/gaganmalvi/gaganmalvi/master/nyan.gif"
        val requestOptions = RequestOptions().error(R.drawable.ic_launcher_foreground)
        Glide.with(this)
            .load(image)
            .apply(requestOptions)
            .into(imageview)
        recyclerView = findViewById(R.id.view)
        recyclerView.adapter = DataAdapter(dataList,this)
        recyclerView.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        progress = ProgressDialog(this)
        progress.setTitle("Loading")
        progress.setCancelable(false)
        progress.show()
        getData()
    }
    private fun getData() {
        val call: Call<List<Model>> = ApiClient.getClient.getPhotos()
        call.enqueue(object : Callback<List<Model>> {

            override fun onResponse(call: Call<List<Model>>?, response: Response<List<Model>>?) {
                progress.dismiss()
                dataList.addAll(response!!.body()!!)
                recyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<Model>>?, t: Throwable?) {
                progress.dismiss()
            }

        })
    }
}