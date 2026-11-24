package com.example.bivvy.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

const val CURRENT_CONSENT_VERSION = 1
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("user_settings")

private object Keys {
    val USERNAME = stringPreferencesKey("username")
    val ONBOARDING_DONE = booleanPreferencesKey("onboarding_done")
    val CONSENT_VERSION = intPreferencesKey("consent_version")
}

@Singleton
class UserRepository @Inject constructor(@ApplicationContext private val context: Context){
    val username: Flow<String?> = context.dataStore.data.map { preferences ->
        preferences[Keys.USERNAME]
    }
    val onboardingDone: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[Keys.ONBOARDING_DONE] ?: false
    }
    suspend fun finishOnboarding(name: String, consentVersion: Int){
        context.dataStore.edit { preferences ->
            preferences[Keys.USERNAME] = name
            preferences[Keys.ONBOARDING_DONE] = true
            preferences[Keys.CONSENT_VERSION] = consentVersion
        }
    }
}