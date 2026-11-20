package com.example.bivvy.ui.screens.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.bivvy.ui.screens.onboarding.steps.AgreementStep
import com.example.bivvy.ui.screens.onboarding.steps.NicknameStep
import com.example.bivvy.ui.screens.onboarding.steps.WelcomeStep
import com.example.bivvy.ui.theme.AppGradient
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen(){

    val pager = rememberPagerState(pageCount = {2})
    val scope = rememberCoroutineScope()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppGradient)
    ){
        HorizontalPager(
            state = pager,
            modifier = Modifier.fillMaxSize(),
            userScrollEnabled = false
        ) { page ->
            when(page){
                0 -> WelcomeStep(onNext = {scope.launch { pager.animateScrollToPage(1) }} )
                1 -> AgreementStep()
                2 -> NicknameStep(onNext = {})
            }

        }

    }
}