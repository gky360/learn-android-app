package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                ComposeQuadrantScreen()
            }
        }
    }
}

@Composable
fun ComposeQuadrantScreen() {
    Surface(color = MaterialTheme.colorScheme.background) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(modifier = Modifier.weight(1f)) {
                Column(modifier = Modifier.weight(1f)) {
                    QuadrantCard(
                        title = stringResource(R.string.first_title),
                        description = stringResource(R.string.first_description),
                        backgroundColor = Color.Green
                    )
                }
                Column(modifier = Modifier.weight(1f)) {
                    QuadrantCard(
                        title = stringResource(R.string.second_title),
                        description = stringResource(R.string.second_description),
                        backgroundColor = Color.Yellow
                    )
                }
            }
            Row(modifier = Modifier.weight(1f)) {
                Column(modifier = Modifier.weight(1f)) {
                    QuadrantCard(
                        title = stringResource(R.string.third_title),
                        description = stringResource(R.string.third_description),
                        backgroundColor = Color.Cyan
                    )
                }
                Column(modifier = Modifier.weight(1f)) {
                    QuadrantCard(
                        title = stringResource(R.string.fourth_title),
                        description = stringResource(R.string.fourth_description),
                        backgroundColor = Color.LightGray
                    )
                }
            }
        }
    }
}

@Composable
fun QuadrantCard(title: String, description: String, backgroundColor: Color) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(text = description, textAlign = TextAlign.Justify)
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantPreview() {
    HappyBirthdayTheme {
        ComposeQuadrantScreen()
    }
}

// ----------------------------------------------------------------

@Composable
fun TaskCompletedScreen() {
    val icon = painterResource(id = R.drawable.ic_task_completed)
    Surface {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
        ) {
            Image(painter = icon, contentDescription = null)
            Text(
                text = stringResource(R.string.all_tasks_completed),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
            )
            Text(
                text = stringResource(R.string.nice_work),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskCompletedPreview() {
    HappyBirthdayTheme {
        TaskCompletedScreen()
    }
}


// ----------------------------------------------------------------

@Composable
fun Article() {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Column {
        Image(
            painter = image,
            contentDescription = null,
        )
        Surface(color = MaterialTheme.colorScheme.background) {
            Column {
                Text(
                    text = stringResource(R.string.article_title),
                    fontSize = 24.sp,
                    modifier = Modifier.padding(16.dp)
                )
                Text(
                    text = stringResource(R.string.article_summary),
                    textAlign = TextAlign.Justify,
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp),
                )
                Text(
                    text = stringResource(R.string.article_text),
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}


@Preview(showBackground = false)
@Composable
fun ArticlePreview() {
    HappyBirthdayTheme {
        Article()
    }
}

// ----------------------------------------------------------------

@Composable
fun Birthday() {
    // A surface container using the 'background' color from the theme
    Surface(color = MaterialTheme.colorScheme.background) {
        BirthdayGreetingWithImage("Happy Birthday Sam!", "- from Emma")
    }
}

@Composable
fun BirthdayGreetingWithText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = message,
            fontSize = 36.sp,
            modifier = Modifier.padding(top = 16.dp),
        )
        Text(
            text = from,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(top = 16.dp, end = 16.dp)
                .align(alignment = Alignment.End),
        )
    }
}

@Composable
fun BirthdayGreetingWithImage(message: String, from: String) {
    val image = painterResource(R.drawable.androidparty)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        BirthdayGreetingWithText(message = message, from = from)
    }
}

@Preview(showBackground = false)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        BirthdayGreetingWithImage(
            stringResource(R.string.happy_birthday_text),
            stringResource(R.string.signature_text)
        )
    }
}
