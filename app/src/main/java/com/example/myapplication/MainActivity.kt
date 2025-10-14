package com.example.myapplication // Make sure this matches your new project's package name

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme { // Updated this line
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ToneChangerScreen()
                }

            }
        }
    }
}

@Composable
fun ToneChangerScreen() {
    // State variables to hold the text and the result
    var inputText by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }

    // Main layout
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()), // Make column scrollable
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "AI Tone Changer",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Text input field
        OutlinedTextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Enter your text here") },
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Action buttons in a row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ToneButton(text = "Professional", modifier = Modifier.weight(1f)) {
                // TODO: Call API
            }
            ToneButton(text = "Casual", modifier = Modifier.weight(1f)) {
                // TODO: Call API
            }
            ToneButton(text = "Shorter", modifier = Modifier.weight(1f)) {
                // TODO: Call API
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Loading indicator and result text
        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.padding(vertical = 16.dp))
        } else {
            Text(
                text = resultText,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surfaceVariant, shape = MaterialTheme.shapes.medium)
                    .padding(16.dp)
            )
        }
    }
}

@Composable
fun ToneButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = modifier.height(48.dp)
    ) {
        Text(text)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme { // Updated this line
        ToneChangerScreen()
    }
}

