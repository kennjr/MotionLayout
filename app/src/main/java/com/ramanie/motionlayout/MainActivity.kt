package com.ramanie.motionlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ramanie.motionlayout.ui.theme.MotionLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MotionLayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var progress by remember {
                        mutableStateOf(0f)
                    }
                    Column(modifier = Modifier.fillMaxSize()) {
                        ProfileHeader(progress = progress)
                        Spacer(modifier = Modifier.height(32.dp))
                        // this is the slider that we'll use to move the animation
                        Slider(value = progress, onValueChange = {
                            // whenever the value of the slider changes then we update the progress
                            progress = it
                        }, modifier = Modifier.padding(horizontal = 40.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MotionLayoutTheme {
        Greeting("Android")
    }
}