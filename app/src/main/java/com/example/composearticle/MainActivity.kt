package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BannerImage(
                        title = stringResource(R.string.title_txt),
                        pharagraph1 = stringResource(R.string.pharagraph1_txt),
                        pharagraph2 = stringResource(R.string.pharagraph2_txt)
                    )
                }
            }
        }
    }
}

@Composable
fun Article(title: String, pharagraph1: String, pharagraph2:String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = modifier
                .padding(16.dp)
        )
        Text(
            text = pharagraph1,
            fontSize = 1.em,
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = pharagraph2,
            fontSize = 1.em,
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(16.dp)
        )
    }
}

@Composable
fun BannerImage(title: String, pharagraph1: String, pharagraph2:String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Article(
            title = title,
            pharagraph1 = pharagraph1,
            pharagraph2 = pharagraph2,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeArticlePreview() {
    ComposeArticleTheme {
        BannerImage(
            title = stringResource(R.string.title_txt),
            pharagraph1 = stringResource(R.string.pharagraph1_txt),
            pharagraph2 = stringResource(R.string.pharagraph2_txt)
        )
    }
}