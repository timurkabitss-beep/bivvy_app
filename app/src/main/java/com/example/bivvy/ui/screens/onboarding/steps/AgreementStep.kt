package com.example.bivvy.ui.screens.onboarding.steps

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
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
        "Stays on your device",
        "Your nickname, chats and keys are stored only on this phone. No accounts, no analytics, no ads: nothing is sent to us."
    ),
    InfoInCard(
        "In a room",
        "People in the same room see your nickname and messages. Messages are encrypted with the room key."
    ),
    InfoInCard(
        "Timers",
        "When a room's timer ends, the room and its messages are deleted from every device. We can't stop people from taking screenshots."
    )
)

@Composable
fun AgreementStep(onAgree: () -> Unit, onDecline: () -> Unit){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Dimens.ScreenHorizontal),
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
        Spacer(modifier = Modifier.height(Dimens.TitleIndentBox))

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(Dimens.CardSpacing)
        ) {
            info.forEach { item ->
                InfoCard(title = item.title, description = item.text)
            }
        }


        Column(
            modifier = Modifier
                .padding(bottom = Dimens.StepBottomHint),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Dimens.ItemSpacing)
        ){
            PrimaryButton(onNext = onAgree, text = "I agree", modifier = Modifier.fillMaxWidth())
            SecondaryButton(onNext = onDecline, text = "I disagree", modifier = Modifier.fillMaxWidth())
        }
    }
}

@Composable
private fun InfoCard(title: String, description: String){

       Column(
           modifier = Modifier
               .fillMaxWidth()
               .clip(GlassShape)
               .background(GlassFill)
               .border(
                   width = Dimens.GlassBorderWidth,
                   brush = GlassEdge,
                   shape = GlassShape
               )
               .padding(Dimens.IndentTextBox),
          verticalArrangement = Arrangement.spacedBy(Dimens.TitleIndentText)
       ) {
           Text(text = title, style = MaterialTheme.typography.labelLarge)
           Text(text = description, color = TextHint, style = MaterialTheme.typography.bodyLarge,)
       }

}