package com.example.kmmdemo.android

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmmdemo.data.data_source.UserService
import com.example.kmmdemo.domain.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.logging.LoggingMXBean
import javax.inject.Inject


@HiltViewModel
class ViewModeel
@Inject
constructor(
    private val userService: UserService
    ): ViewModel() {



    val users: MutableState<List<User>?> = mutableStateOf(null)



    fun getData (){

        try {
            viewModelScope.launch{
                users.value = userService.getUsers()
                println("KtorTest: ${users.value?.get(0)?.organizations_url}")
            }

        }catch (e: Exception){
            print("error${e.localizedMessage}")
            // will throw exception if arg is not there for whatever reason.
            // we don't need to do anything because it will already show a composable saying "Unable to get the details of this recipe..."
        }
    }

}

