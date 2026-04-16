package com.example.praktam_2407051026

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.praktam_2407051026.model.Hero
import com.example.praktam_2407051026.model.MLBB
import com.example.praktam_2407051026.ui.theme.PrakTam_2407051026Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrakTam_2407051026Theme {
                HeroScreen()
            }
        }
    }
}

@Composable
fun HeroScreen() {
    val heroes = MLBB.HeroTierA

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {


        item {
            Text(
                text = "Hero Populer",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(heroes) { hero ->
                    HeroRowItem(hero)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Semua Hero",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }


        items(heroes) { hero ->
            HeroCard(hero)
        }
    }
}

@Composable
fun HeroRowItem(hero: Hero) {
    Card(
        modifier = Modifier.width(140.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column {
            Image(
                painter = painterResource(hero.imageRes),
                contentDescription = hero.nama,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = hero.nama,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = hero.role,
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun HeroCard(hero: Hero) {

    var isFavorite by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column {

            Box {
                Image(
                    painter = painterResource(hero.imageRes),
                    contentDescription = hero.nama,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )

                IconButton(
                    onClick = { isFavorite = !isFavorite },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                ) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                        contentDescription = "Favorite",
                        tint = if (isFavorite) Color.Red else Color.White
                    )
                }
            }

            Column(modifier = Modifier.padding(12.dp)) {

                Text(
                    text = hero.nama,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = hero.role,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = { },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Pick Hero")
                }
            }
        }
    }
}
