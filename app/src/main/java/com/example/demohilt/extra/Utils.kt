package com.example.demohilt.extra

import android.app.Activity
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.demohilt.data.NetworkClass
import com.example.demohilt.data.UserModel
import com.google.gson.Gson
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Response

fun <T> Response<T>.networkClass(): NetworkClass<T> {
    val result = this.body()
    val message = Gson().toJsonTree(this.body()).asJsonObject
    return try {
        if (this.code() == 500) {
            NetworkClass.Error("Server Error" + this.message())
        } else if (this.isSuccessful) {
            NetworkClass.Success(result!!, "message")
        } else {
            NetworkClass.Error("")
        }
    } catch (e: Exception) {
        NetworkClass.Error("${e.message}")
    }
}

fun <T> NetworkClass<T>.emitResponse(): NetworkClass<T> {

    return when (this) {
        is NetworkClass.Success -> NetworkClass.Success(this.data!!, this.message)
        is NetworkClass.Error -> NetworkClass.Error(this.message)
        is NetworkClass.Loading -> NetworkClass.Loading()
    }
}

fun Activity.createLog(message: Any) {
    Log.e(javaClass.simpleName, "Create Log:$message ")
}

fun ViewModel.createLog(message: Any) {
    Log.e(javaClass.simpleName, "Create Log:$message")
}
