package com.cesar.reto_apuesta_total

import android.content.SharedPreferences
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.cesar.reto_apuesta_total.presentation.navigation.SetupNavGraph
import com.cesar.reto_apuesta_total.ui.theme.Reto_apuesta_totalTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    private val preferences: SharedPreferences by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Reto_apuesta_totalTheme {
                val user = preferences.getString("USER",null)
                val navController = rememberNavController()
                val isLogged = (user!=null)
                SetupNavGraph(navController = navController,isLogged =  isLogged)
            }
        }
    }

    fun softInputUnspecified(){
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }

    fun logOut(){
        preferences.edit().putString("USER", null).apply()
    }
}
