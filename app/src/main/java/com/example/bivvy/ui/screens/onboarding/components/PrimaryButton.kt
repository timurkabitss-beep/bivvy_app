package com.example.bivvy.ui.screens.onboarding.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.bivvy.ui.theme.AppGradient
import com.example.bivvy.ui.theme.ButtonContainerDisabled

@Composable
fun PrimaryButton(
    onNext: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
){
    Button(
        onClick = onNext,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            disabledContainerColor = ButtonContainerDisabled
        )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge.copy(brush = AppGradient)
        )
    }
}