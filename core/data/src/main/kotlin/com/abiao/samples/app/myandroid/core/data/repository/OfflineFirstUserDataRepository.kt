package com.abiao.samples.app.myandroid.core.data.repository

import com.abiao.samples.app.myandroid.core.datastore.NiaPreferencesDataSource
import com.abiao.samples.apps.myandroid.core.model.data.UserData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class OfflineFirstUserDataRepository @Inject constructor(
    private val niaPreferencesDataSource: NiaPreferencesDataSource,
): UserDataRepository {
    override val userData: Flow<UserData> = niaPreferencesDataSource.userData
}