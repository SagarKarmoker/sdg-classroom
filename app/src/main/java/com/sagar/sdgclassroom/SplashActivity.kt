package com.sagar.sdgclassroom

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.sagar.sdgclassroom.ui.theme.SDGClassroomTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SDGClassroomTheme {
                SplashScreen { // Pass navigation callback
                    navigateToMainActivity() // Call method to navigate to MainActivity
                }
            }
        }
    }

    // Function to navigate to MainActivity
    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Close the splash activity so the user can't go back to it
    }
}

@Composable
fun SplashScreen(onTimeout: () -> Unit) {
    // Remember coroutine scope to run the splash screen timeout
    LaunchedEffect(Unit) {
        // Delay for 2 seconds
        delay(2000)
        onTimeout() // Callback to navigate to next screen
    }

    // Design your splash screen layout
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground), // Use your own logo or image
            contentDescription = "App Logo",
            modifier = Modifier.size(128.dp),
            colorFilter = ColorFilter.tint(color = androidx.compose.ui.graphics.Color.Blue)
        )
        Text(
            text = "Welcome to SDG Classroom!",
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashPreview() {
    SDGClassroomTheme {
        SplashScreen(onTimeout = {})
    }
}
