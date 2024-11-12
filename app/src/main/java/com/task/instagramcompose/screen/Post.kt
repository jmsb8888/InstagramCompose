import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Text
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.background
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Man
import androidx.compose.material.icons.filled.MarkEmailUnread
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.IconButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember


@Composable
fun InstagramCloneUI() {
    MaterialTheme(
        colorScheme = darkColorScheme(
            primary = Color(0xFF6200EE),
            secondary = Color(0xFF03DAC6),
            background = Color.Black,
            surface = Color(0xFF121212),
            onBackground = Color.White,
            onSurface = Color.White
        )
    ) {
        Scaffold(
            topBar = { InstagramTopBar() },
            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .background(Color.Black)
                ) {

                    PostsList()
                }
            }

        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InstagramTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Instagram",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
        },
        actions = {
            Row {
                IconButton(onClick = { /* Acción de notificaciones */ }) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Notifications",
                        modifier = Modifier.size(24.dp),
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
                IconButton(onClick = { /* Acción de mensajes */ }) {
                    Icon(
                        imageVector = Icons.Filled.MarkEmailUnread,
                        contentDescription = "Messages",
                        modifier = Modifier.size(24.dp),
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    )
}

@Composable
fun StoriesRow() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        items(11) { index ->
            if (index == 0) {
                AddStoryItem()
            } else {
                StoryItem()
            }
        }
    }
}

@Composable
fun AddStoryItem() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(70.dp)
                .background(Color.Gray, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = "Profile",
                modifier = Modifier.size(50.dp),
                tint = Color.White
            )
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(4.dp)
                    .background(Color.Blue, shape = CircleShape)
                    .size(24.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add Story",
                    modifier = Modifier.fillMaxSize(),
                    tint = Color.White
                )
            }
        }
        Text(
            text = "Tu historia",
            fontSize = 12.sp,
            color = Color.White,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun StoryItem() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(70.dp)
                .background(Color.Gray, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = "Story",
                modifier = Modifier.size(64.dp),
                tint = Color.White
            )
        }
        Text(
            text = "User",
            fontSize = 12.sp,
            color = Color.White,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun PostsList() {
    var index = 0
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        items(5) {
            if(index == 0) {
                StoriesRow()
                index++
            }
            PostItem()
        }
    }
}
@Composable
fun PostItem() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = "Profile",
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Gray, shape = CircleShape)
                    .padding(4.dp),
                tint = Color.White
            )
            Text(
                text = "User Name",
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.Image,
                contentDescription = "Post Image",
                modifier = Modifier.size(100.dp),
                tint = Color.Gray
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Like",
                        modifier = Modifier
                            .size(24.dp)
                            .padding(horizontal = 4.dp),
                        tint = Color.White
                    )
                    Text(
                        text = "40",
                        fontSize = 14.sp,
                        color = Color.White,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.ChatBubble,
                        contentDescription = "Comment",
                        modifier = Modifier
                            .size(24.dp)
                            .padding(horizontal = 4.dp),
                        tint = Color.White
                    )
                    Text(
                        text = "32",
                        fontSize = 14.sp,
                        color = Color.White,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Send,
                        contentDescription = "Share",
                        modifier = Modifier
                            .size(24.dp)
                            .padding(horizontal = 4.dp),
                        tint = Color.White
                    )
                    Text(
                        text = "25",
                        fontSize = 14.sp,
                        color = Color.White,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }
            Icon(
                imageVector = Icons.Filled.Bookmark,
                contentDescription = "Bookmark",
                modifier = Modifier.size(24.dp),
                tint = Color.White
            )
        }

        Text(
            text = "Me gusta por 1000 personas",
            fontSize = 14.sp,
            color = Color.White
        )
        Text(
            text = "Hace 11 horas",
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}
