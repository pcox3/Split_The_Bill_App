package com.uiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.baseproject.App
import com.uiapp.theme.AppTheme
import com.uiapp.theme.greyLight
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(
                    containerColor = greyLight
                ) { paddingValues ->
                    Column(modifier = Modifier.padding(paddingValues)) {
                        App()
                    }
                }
            }
        }
    }
}