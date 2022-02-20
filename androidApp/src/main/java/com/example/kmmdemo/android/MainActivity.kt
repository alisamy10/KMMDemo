package com.example.kmmdemo.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import com.example.kmmdemo.Greeting
import android.widget.TextView
import androidx.activity.viewModels
import com.example.kmmdemo.android.di.NetworkModule.BASE_URL
import com.example.kmmdemo.data.data_source.UserServiceImpl
import dagger.hilt.android.AndroidEntryPoint

import com.example.kmmdemo.data.data_source.network.KtorClientFactory
import com.example.kmmdemo.data.data_source.network.toDomainUser
import com.example.kmmdemo.data.data_source.network.toDomainUserList
import com.example.kmmdemo.data.model.UserDto

import io.ktor.client.request.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

//@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

  //  private val viewModel: ViewModeel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // viewModel.getData()


        CoroutineScope(IO).launch {
            val userService = UserServiceImpl(
                httpClient = KtorClientFactory().build(),
                baseUrl = BASE_URL,
            )
            val user = userService.getUsers()
            println("KtorTest: ${user.get(0).avatar_url}")
        }




        val tv: TextView = findViewById(R.id.text_view)
        tv.text = "Welcome"
    }
}
