package com.example.bivvy.ui.screens.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bivvy.data.datastore.CURRENT_CONSENT_VERSION
import com.example.bivvy.data.datastore.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel(){
    fun onUsernameConfirmed(name: String, onDone: () -> Unit){
        viewModelScope.launch {
            userRepository.finishOnboarding(name, CURRENT_CONSENT_VERSION)
            onDone()
        }
    }
}