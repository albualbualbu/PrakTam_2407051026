package com.example.praktam_2407051026

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.praktam_2407051026.model.MLBB
import com.example.praktam_2407051026.ui.theme.PrakTam_2407051026Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrakTam_2407051026Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HeroDetail(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Halo, saya [Albu] dengan NPM [2407051026] siap belajar Compose!",
        modifier = modifier
    )
}

@Composable
fun HeroDetail(modifier: Modifier = Modifier) {
    val hero = MLBB.HeroTierA[0]   // ← pakai "hero", bukan "food"

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Image(
            painter = painterResource(id = hero.imageRes),
            contentDescription = hero.nama,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        Text(text = "Nama: ${hero.nama}")
        Text(text = "Role: ${hero.role}")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PrakTam_2407051026Theme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun HeroDetailPreview() {
    PrakTam_2407051026Theme {
        HeroDetail()
    }
}