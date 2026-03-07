package com.abiao.samples.app.myandroid.core.datastore

import androidx.datastore.core.DataStore
import com.abiao.samples.apps.myandroid.core.datastore.UserPreferences
import com.abiao.samples.apps.myandroid.core.model.data.UserData
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NiaPreferencesDataSource @Inject constructor(
    private val userPreferences: DataStore<UserPreferences>,
) {
    val userData = userPreferences.data
        .map {
            UserData(
                useDynamicColor = it.useDynamicColor
            )
        }
}