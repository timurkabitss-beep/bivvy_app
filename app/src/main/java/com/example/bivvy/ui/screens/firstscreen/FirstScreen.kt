package com.example.bivvy.ui.screens.firstscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bivvy.ui.theme.AppGradient
import com.example.bivvy.ui.theme.Typography


@Composable
fun FirstScreen(modifier: Modifier = Modifier){
    var showDialog by remember { mutableStateOf(false) }
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(brush = AppGradient)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 90.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(30.dp))
            Text("Bivvy", style = Typography.displaySmall, color = Color.White)
            Spacer(Modifier.height(8.dp))
            Text("Closer than it looks", style = Typography.bodyLarge, color = Color.White.copy(alpha = 0.7f))
        }

        PulseWaveButton(
            onClick = {showDialog = true},
            modifier = Modifier.align(Alignment.Center)
        )
        if (showDialog){
            DialogNewUser(
                onConfirm = {showDialog = false},
                onDismiss = {showDialog = false}
            )
        }

        Text(
            "No internet. No servers. No traces.",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 70.dp),
            style = Typography.bodyLarge,
            color = Color.White.copy(alpha = 0.5f)
        )
    }
}