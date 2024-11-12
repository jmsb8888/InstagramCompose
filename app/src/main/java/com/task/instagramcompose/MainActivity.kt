package com.task.instagramcompose

import InstagramCloneUI
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.task.instagramcompose.screen.InstagramBottomMenu
import com.task.instagramcompose.screen.InstagramSearchScreen
import com.task.instagramcompose.ui.theme.InstagramComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InstagramComposeTheme {
                var currentScreen by remember { mutableStateOf("search") }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        InstagramBottomMenu(
                            onHomeClick = { currentScreen = "home" },
                            onSearchClick = { currentScreen = "search" },
                            onAddClick = { /* Acción para Agregar */ },
                            onReelsClick = { /* Acción para Reels */ },
                            onProfileClick = { /* Acción para Perfil */ }
                        )
                    }
                ) { innerPadding ->
                    when (currentScreen) {
                        "home" -> InstagramCloneUI()
                        "search" -> InstagramSearchScreen(modifier = Modifier.padding(innerPadding))
                        else -> InstagramCloneUI()
                    }
                }
            }
        }
    }
}


