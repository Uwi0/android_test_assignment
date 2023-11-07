package com.kakapo.miitest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kakapo.designsystem.theme.AppTheme
import com.kakapo.miitest.feature.home.HomeRoute
import com.kakapo.miitest.feature.home.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                HomeRoute()
            }
        }
    }
}
