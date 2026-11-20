package com.example.bivvy.ui.screens.onboarding.steps

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import com.example.bivvy.ui.screens.onboarding.components.PrimaryButton
import com.example.bivvy.ui.theme.AppGradient
import com.example.bivvy.ui.theme.ButtonContainerDisabled
import com.example.bivvy.ui.theme.Dimens
import com.example.bivvy.ui.theme.GlassEdge
import com.example.bivvy.ui.theme.GlassFill
import com.example.bivvy.ui.theme.GlassShape
import com.example.bivvy.ui.theme.TextHint
import com.example.bivvy.ui.theme.TextSecondary
import com.example.bivvy.ui.theme.Typography

private const val NICK_MIN = 2
private const val NICK_MAX = 12
@Composable
fun NicknameStep(onNext: () -> Unit){
    var username by remember{mutableStateOf("")}

    Box(
        modifier = Modifier
            .fillMaxSize()
            .imePadding()
    ){
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = Dimens.StepTitleTop),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Dimens.TitleSubtitleGap)
        ) {
            Text("Your name", style = MaterialTheme.typography.displaySmall)
            Text("Come up with a username for yourself", style = MaterialTheme.typography.bodyLarge, color = TextSecondary)
        }
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = Dimens.ScreenHorizontal),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Dimens.ItemSpacing)
        ) {
            OutlinedTextField(
                value = username,
                onValueChange = {if (it.length <= NICK_MAX) username = it },
                singleLine = true,
                shape = GlassShape,
                placeholder = {
                    Text(text = "Enter username",
                         color = TextHint
                        )
                },
                suffix = {
                    Text(text = "${username.length}/$NICK_MAX", color = TextHint)
                },
                modifier = Modifier
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
                    // Делаем стандартные рамки Material3 прозрачными, так как рисуем свою стеклянную
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    errorBorderColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                )
            )
            PrimaryButton(
                onNext = {},
                text = "Sign in",
                enabled = username.trim().length >= NICK_MIN,
            )
        }

    }
}