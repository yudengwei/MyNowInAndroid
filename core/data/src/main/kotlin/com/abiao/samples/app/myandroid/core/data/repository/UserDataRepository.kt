package com.abiao.samples.app.myandroid.core.data.repository

import com.abiao.samples.apps.myandroid.core.model.data.UserData
import kotlinx.coroutines.flow.Flow

interface UserDataRepository {

    val userData: Flow<UserData>
}