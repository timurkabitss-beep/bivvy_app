package com.example.bivvy.ui.screens.onboarding.steps

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bivvy.ui.screens.onboarding.components.PulseWaveButton
import com.example.bivvy.ui.theme.AppGradient
import com.example.bivvy.ui.theme.Dimens
import com.example.bivvy.ui.theme.TextHint
import com.example.bivvy.ui.theme.TextSecondary
import com.example.bivvy.ui.theme.Typography


@Composable
fun WelcomeStep(onNext:() -> Unit, modifier: Modifier = Modifier){

    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = Dimens.StepTitleTop),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Dimens.TitleSubtitleGap)
        ) {
            Text("Bivvy", style = Typography.displaySmall, color = Color.White)
            Text("Closer than it looks", style = MaterialTheme.typography.bodyLarge, color = TextSecondary)
        }

        PulseWaveButton(
            onClick = onNext,
            modifier = Modifier.align(Alignment.Center)
        )


        Text(
            "No internet. No servers. No traces.",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = Dimens.StepBottomHint),
            style = MaterialTheme.typography.bodyLarge,
            color = TextHint
        )
    }
}