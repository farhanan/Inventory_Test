package com.farhan.test.data.local.preferences

import android.content.Context
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.emptyPreferences
import androidx.datastore.preferences.preferencesKey
import com.farhan.test.util.emptyString
import com.farhan.test.util.Const
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.*

class AccessManager(context: Context) {
    private val nothingName = TOKEN_ACCESS_REF.toUpperCase(Locale.ROOT)
    private val dataStore = context.createDataStore(name = nothingName)

    suspend fun setAccess(tokenAccess: String) {
        dataStore.edit { preferences ->
            preferences[accessKey] = "${Const.Access.AUTH_PREFIX} $tokenAccess"
        }
    }

    fun setAccess(tokenAccess: String, scope: CoroutineScope) = scope.launch {
        dataStore.edit { preferences ->
            preferences[accessKey] = "${Const.Access.AUTH_PREFIX} $tokenAccess"
        }
    }

    suspend fun clearAccess() {
        dataStore.edit { preferences ->
            preferences[accessKey] = emptyString
        }
    }

    fun clearAccess(scope: CoroutineScope) = scope.launch {
        dataStore.edit { preferences ->
            preferences[accessKey] = emptyString
        }
    }

    val access: Flow<String> = dataStore.data
            .catch { throwable ->
                emit(emptyPreferences())
                Timber.e(throwable)
            }.map { preferences ->
                preferences[accessKey] ?: emptyString
            }

}

const val TOKEN_ACCESS_REF = "token_access_key"
private val accessKey = preferencesKey<String>(TOKEN_ACCESS_REF)
