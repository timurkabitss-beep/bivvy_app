package com.example.bivvy.ui.screens.onboarding.steps

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bivvy.ui.theme.AppGradient
import com.example.bivvy.ui.theme.Typography

@Composable
fun NicknameStep(onNext: () -> Unit){
    var username by remember{mutableStateOf("username")}

    Box(
        modifier = Modifier
            .fillMaxSize()
            .imePadding()
    ){
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 90.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(Modifier.height(30.dp))
            Text("Your name", style = Typography.displaySmall, color = Color.White)
            Spacer(Modifier.height(8.dp))
            Text("Come up with a username for yourself", style = Typography.bodyLarge, color = Color.White.copy(alpha = 0.7f))
            Spacer(Modifier.height(30.dp))
        }
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                username,
                {username = it},
                singleLine = true,
                isError = username.isNotEmpty() && username.length < 12,
            )
            Button(
                modifier = Modifier
                    .background(color = Color.White),
                onClick = {},
            ) {
                Text(
                    text = "Sign in",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        brush = AppGradient
                    )
                )


            }
        }

    }
}