package com.abiao.mynowinandroid

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abiao.samples.app.myandroid.core.data.repository.UserDataRepository
import com.abiao.samples.apps.myandroid.core.model.data.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    userDataRepository: UserDataRepository,
): ViewModel() {

    val uiState: StateFlow<MainActivityUiState> = userDataRepository.userData.map {
        MainActivityUiState.Success(it)
    }.stateIn(
        scope = viewModelScope,
        initialValue = MainActivityUiState.Loading,
        /**
         * SharingStarted.WhileSubscribed(5_000) 的意思是：
         *
         * WhileSubscribed：只有在有订阅者时才共享/收集上游 Flow
         * 5_000：Kotlin 里的数字分隔写法，等于 5000，单位是 毫秒
         * 合起来就是：最后一个订阅者取消后，不是立刻停止，而是等 5 秒再停止上游收集
         * 更具体一点：
         *
         * 第一个 collector 出现时：开始收集上游
         * 最后一个 collector 消失时：先等 5000ms
         * 如果这 5 秒内又有新的 collector 来了：不会停
         * 如果 5 秒后还没人订阅：停止上游
         * 之后再有人订阅：重新启动上游
         * 再补一个很容易忽略的点：
         *
         * 你这里只传了一个参数，所以第二个参数用默认值
         * 默认是 不清空 replay/cache
         * 如果它配合 stateIn 用，停止后会保留最后一个值，不会重置回 initialValue
         * 所以你可以把它简单理解成：
         *
         * SharingStarted.WhileSubscribed(5_000)
         * = “有人看就跑；没人看时先等 5 秒，再停；缓存先留着。”
         */
        started = SharingStarted.WhileSubscribed(5_000),
    )


}

sealed interface MainActivityUiState {
    data object Loading: MainActivityUiState

    data class Success(val userData: UserData): MainActivityUiState{

    }

    fun shouldKeepSplashScreen() = this is Loading
}