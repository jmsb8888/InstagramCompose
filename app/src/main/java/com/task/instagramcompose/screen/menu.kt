package com.task.instagramcompose.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
@Composable
fun InstagramBottomMenu(
    onHomeClick: () -> Unit,
    onSearchClick: () -> Unit,
    onAddClick: () -> Unit,
    onReelsClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.Black)
            .padding(bottom = 43.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Filled.Home,
            contentDescription = "Home",
            modifier = Modifier
                .size(32.dp)
                .clickable { onHomeClick() }
                .padding(4.dp),
            tint = Color.White
        )

        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = "Search",
            modifier = Modifier
                .size(32.dp)
                .clickable { onSearchClick() }
                .padding(4.dp),
            tint = Color.White
        )

        Box(
            modifier = Modifier
                .size(27.dp)
                .background(Color.White, shape = CircleShape)
                .clickable { onAddClick() }
                .padding(4.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Add",
                modifier = Modifier.size(24.dp),
                tint = Color.Black
            )
        }

        Icon(
            imageVector = Icons.Filled.VideoLibrary,
            contentDescription = "Reels",
            modifier = Modifier
                .size(32.dp)
                .clickable { onReelsClick() }
                .padding(4.dp),
            tint = Color.White
        )
        Icon(
            imageVector = Icons.Filled.Person,
            contentDescription = "Profile",
            modifier = Modifier
                .size(27.dp)
                .background(
                    color = Color.Gray,
                    shape = CircleShape
                )
                .clickable { onProfileClick() }
                .padding(8.dp),
            tint = Color.White
        )
    }
}
