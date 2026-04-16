package com.example.praktam_2407051026

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.praktam_2407051026.model.Hero
import com.example.praktam_2407051026.model.MLBB
import com.example.praktam_2407051026.ui.theme.PrakTam_2407051026Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrakTam_2407051026Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HeroListScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun HeroListScreen(modifier: Modifier = Modifier) {
    val heroes = MLBB.HeroTierA

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(12.dp)
    ) {
        heroes.forEach { hero ->
            HeroDetail(hero = hero)
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun StatBar(label: String, value: Float, color: Color) {
    val animValue by animateFloatAsState(
        targetValue = value,
        animationSpec = tween(1000),
        label = "stat"
    )

    Column {
        Text(label, fontWeight = FontWeight.Medium)
        Box(
            Modifier
                .fillMaxWidth()
                .height(6.dp)
                .background(Color.LightGray)
        ) {
            Box(
                Modifier
                    .fillMaxWidth(animValue)
                    .fillMaxHeight()
                    .background(color)
            )
        }
    }
}

@Composable
fun HeroDetail(hero: Hero) {


    var isFavorite by remember { mutableStateOf(false) }

    val stats = when (hero.role.lowercase()) {
        "assassin" -> listOf(0.9f, 0.3f, 0.8f, 0.7f)
        "mage" -> listOf(0.8f, 0.4f, 0.5f, 0.6f)
        "tank" -> listOf(0.5f, 0.9f, 0.4f, 0.4f)
        "marksman" -> listOf(0.8f, 0.3f, 0.5f, 0.6f)
        else -> listOf(0.6f, 0.6f, 0.6f, 0.5f)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {

            Image(
                painter = painterResource(hero.imageRes),
                contentDescription = hero.nama,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )


            IconButton(
                onClick = { isFavorite = !isFavorite },
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(10.dp)
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
                hero.nama,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                hero.role,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(10.dp))

            listOf("Damage", "Durability", "Mobility", "Difficulty")
                .forEachIndexed { i, label ->
                    StatBar(label, stats[i], Color.Blue)
                    Spacer(modifier = Modifier.height(6.dp))
                }

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

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    PrakTam_2407051026Theme {
        HeroListScreen()
    }
}
