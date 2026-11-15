package com.example.bivvy.ui.screens.firstscreen

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.StartOffset
import androidx.compose.animation.core.StartOffsetType
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bivvy.ui.theme.AppGradient

@Composable
fun PulseWaveButton(
    onClick: ()-> Unit,
    modifier: Modifier = Modifier,
    circleSize: Dp = 110.dp,
    waveCount: Int = 3,
    durationMillis: Int = 2400
){
    val source = remember { MutableInteractionSource() }
    val pressed by source.collectIsPressedAsState()
    val pressedScale by animateFloatAsState(
        targetValue = if (pressed) 0.92f else 1f
    )
    val transition = rememberInfiniteTransition("breath")
    val pulse by transition.animateFloat(
        initialValue = 1f,
        targetValue = 1.06f,
        animationSpec = infiniteRepeatable(
            repeatMode = RepeatMode.Reverse,
            animation = tween(durationMillis/2,easing = FastOutSlowInEasing)
        ),
        label = "breath"
    )

    Box(
        modifier = modifier
            .size(circleSize * 2.2f),
        contentAlignment = Alignment.Center
    ){
        for (i in 0 until waveCount){
            val startOffset = (durationMillis/waveCount) * i
            val progress by transition.animateFloat(
                initialValue = 0f,
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis, easing = LinearOutSlowInEasing),
                    repeatMode = RepeatMode.Restart,
                    initialStartOffset = StartOffset(startOffset, StartOffsetType.FastForward)
                ),
                label = "wave_$i"
            )
            Box(
                modifier = Modifier
                    .size(circleSize)
                    .graphicsLayer{
                        alpha = (1f - progress) * 0.6f
                        scaleX = 1f + progress * 1.2f
                        scaleY = 1f + progress * 1.2f
                    }
                    .border(2.dp,Color.White,CircleShape )
            ){
            }
        }

        Box(
            modifier = Modifier
                .size(circleSize)
                .clickable(interactionSource = source, indication = null){onClick()}
                .graphicsLayer{
                    scaleX = pressedScale * pulse
                    scaleY = pressedScale * pulse
                }

                .clip(shape = CircleShape)
                .background(color = Color.White),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "Lets go",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    brush = AppGradient
                )
            )


        }

    }


}