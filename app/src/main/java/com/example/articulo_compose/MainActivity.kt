package com.example.articulo_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.FontScaling
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.articulo_compose.ui.theme.ArticuloComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArticuloComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingImage(
                        message = stringResource(R.string.jetpack_compose_tutorial),
                        paragraph = stringResource(R.string.modern_toolkit),
                        paragraph2 = stringResource(R.string.simple_ui_component),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun GreetingText(message: String, paragraph: String, paragraph2: String ,modifier: Modifier=Modifier){
    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.jetpack_compose_tutorial),
            fontSize = 25.sp,
            lineHeight = 50.sp,

            )
        Text(text = stringResource(R.string.modern_toolkit),
            modifier=Modifier.padding(top = 16.dp))
        Text(text = stringResource(R.string.simple_ui_component),
            modifier=Modifier.padding(top = 16.dp))
    }
}

@Composable
fun GreetingImage(message:String, paragraph: String,paragraph2: String, modifier: Modifier = Modifier ){
    val image = painterResource(R.drawable.bg_compose_background)
    Column(modifier = modifier) {
        Image(painter = image, contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        GreetingText(
            message = message,
            paragraph = paragraph,
            paragraph2 = paragraph2,
            modifier = Modifier.padding(15.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArticuloComposeTheme {
        GreetingImage(
            message = stringResource(R.string.jetpack_compose_tutorial),
            paragraph = stringResource(R.string.modern_toolkit),
            paragraph2 = stringResource(R.string.simple_ui_component))
    }
}