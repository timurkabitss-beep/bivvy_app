package com.example.bivvy.ui.screens.onboarding.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bivvy.ui.theme.Dimens
import com.example.bivvy.ui.theme.GlassEdge
import com.example.bivvy.ui.theme.GlassFill
import com.example.bivvy.ui.theme.TextHint
import com.example.bivvy.ui.theme.TextSecondary


@Composable
fun SecondaryButton(
    onNext: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
){
    OutlinedButton(
        onClick = onNext,
        modifier= modifier,
        border = BorderStroke(Dimens.GlassBorderWidth, GlassEdge),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = TextSecondary)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge
        )
    }
}