package dev.hackwithsodiq.android_06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import dev.hackwithsodiq.android_06.recyclerview.Adapter
import dev.hackwithsodiq.android_06.retrofit.RetrofitService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val editUserInput  = findViewById<TextInputEditText>(R.id.edit_username)
        val btnSearch = findViewById<Button>(R.id.btn_search)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        val builder = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = builder.create(RetrofitService::class.java)

        btnSearch.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            val query = editUserInput.text.toString()
            Log.v("MainActivity", query)

            lifecycleScope.launch {
                try {
                    val response = service.listRepos(query)
                    progressBar.visibility = View.GONE

                    if (response != null){
                        val adapter = Adapter(response){position->
                            Toast.makeText(this@MainActivity, "Item clicked $position",
                                Toast.LENGTH_SHORT).show()
                        }
                        recyclerView.adapter = adapter
                    }else{
                        Toast.makeText(this@MainActivity,
                            "Response is null", Toast.LENGTH_SHORT).show()
                    }
                }catch (e:Exception){

                    progressBar.visibility = View.GONE
                    Toast.makeText(this@MainActivity,
                        "An error occur", Toast.LENGTH_SHORT).show()
                    Log.v("MainActivity", e.message ?: "")
                }
            }
        }
    }
}