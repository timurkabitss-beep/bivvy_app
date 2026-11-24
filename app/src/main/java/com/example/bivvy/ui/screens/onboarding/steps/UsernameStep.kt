package com.example.bivvy.ui.screens.onboarding.steps

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.example.bivvy.data.datastore.UserRepository
import com.example.bivvy.ui.screens.onboarding.components.PrimaryButton
import com.example.bivvy.ui.theme.Dimens
import com.example.bivvy.ui.theme.GlassEdge
import com.example.bivvy.ui.theme.GlassFill
import com.example.bivvy.ui.theme.GlassShape
import com.example.bivvy.ui.theme.TextHint
import com.example.bivvy.ui.theme.TextSecondary
import kotlinx.coroutines.launch

private const val NICK_MIN = 2
private const val NICK_MAX = 12

@Composable
fun UsernameStep(
    onConfirm: (String) -> Unit
) {
    var username by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .imePadding()
            .padding(horizontal = Dimens.ScreenHorizontal),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier.padding(top = Dimens.StepTitleTop),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Dimens.TitleSubtitleGap)
        ) {
            Text("Your name", style = MaterialTheme.typography.displaySmall)
            Text("Come up with a username for yourself",
                style = MaterialTheme.typography.bodyLarge,
                color = TextSecondary
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = username,
                onValueChange = { if (it.length <= NICK_MAX) username = it },
                singleLine = true,
                shape = GlassShape,
                placeholder = { Text(text = "Enter username", color = TextHint) },
                suffix = {
                    Text(
                        text = "${username.length}/$NICK_MAX",
                        style = MaterialTheme.typography.bodySmall,
                        color = TextHint
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(GlassShape)
                    .background(GlassFill)
                    .border(
                        width = Dimens.GlassBorderWidth,
                        brush = GlassEdge,
                        shape = GlassShape
                    ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White,
                    // Родную рамку Material прячем: стеклянную рисует модификатор border выше
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                )
            )
        }


        Column(
            modifier = Modifier.padding(bottom = Dimens.StepBottomHint),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PrimaryButton(
                onNext = {
                    onConfirm(username.trim())
                },
                text = "Continue",
                enabled = username.trim().length >= NICK_MIN,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}