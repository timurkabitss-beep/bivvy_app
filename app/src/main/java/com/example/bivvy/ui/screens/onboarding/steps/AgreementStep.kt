package com.example.bivvy.ui.screens.onboarding.steps

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.example.bivvy.ui.screens.onboarding.components.PrimaryButton
import com.example.bivvy.ui.screens.onboarding.components.SecondaryButton
import com.example.bivvy.ui.theme.Dimens
import com.example.bivvy.ui.theme.GlassEdge
import com.example.bivvy.ui.theme.GlassFill
import com.example.bivvy.ui.theme.GlassShape
import com.example.bivvy.ui.theme.TextHint
import com.example.bivvy.ui.theme.TextSecondary

private data class InfoInCard(
    val title: String,
    val text: String
)

private val info = listOf(
    InfoInCard(
        "On your device",
        "Your nickname, chats and keys are stored only on this phone."
    ),
    InfoInCard(
        "In a room",
        "People in the same room see your nickname and messages. Messages are encrypted with the room key."
    ),
    InfoInCard(
        "No servers",
        "No accounts, no analytics, no ads. Nothing is sent to us."
    ),
    InfoInCard(
        "Timers",
        "When a room’s timer ends, the room and its messages are deleted from every device. We can’t stop people from taking screenshots."
    )
)

@Composable
fun AgreementStep(){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column(
            modifier = Modifier
                .padding(top = Dimens.StepTitleTop),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Dimens.TitleSubtitleGap)
        ) {
            Text("Before we start", style = MaterialTheme.typography.displaySmall)
            Text("Here’s what happens with your data", style = MaterialTheme.typography.bodyLarge, color = TextSecondary)
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = Dimens.ScreenHorizontal),
            verticalArrangement = Arrangement.spacedBy(Dimens.ItemSpacing)
        ) {
            info.forEach { item ->
                InfoCard(title = item.title, description = item.text)
            }
        }


        Column(
            modifier = Modifier
                .padding(horizontal = Dimens.ScreenHorizontal),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Dimens.ItemSpacing)
        ){
            PrimaryButton(onNext = {}, text = "I agree", modifier = Modifier.fillMaxWidth())
            SecondaryButton(onNext = {}, text = "I disagree", modifier = Modifier.fillMaxWidth())
        }
    }
}

@Composable
private fun InfoCard(title: String, description: String){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(GlassShape)
            .background(GlassFill)
            .border(
                width = Dimens.GlassBorderWidth,
                brush = GlassEdge,
                shape = GlassShape
            )
            .padding(),
    ){
        Text(text = title, style = MaterialTheme.typography.labelLarge)
        Text(text = description, color = TextHint)
    }
}