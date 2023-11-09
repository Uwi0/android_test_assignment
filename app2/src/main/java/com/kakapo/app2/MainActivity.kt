package com.kakapo.app2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.kakapo.common.utils.showLongToast
import com.kakapo.designsystem.component.topAppBar.CustomTopAppbar
import com.kakapo.designsystem.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewMode: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            viewMode.uiSideEffect.collect{effect ->
                when(effect){
                    is ShowError -> baseContext.showLongToast("Error ${effect.message}")
                }
            }
        }
        setContent {
            AppTheme {
                Scaffold(
                    topBar = {
                        CustomTopAppbar(title = stringResource(id = R.string.app_name))
                    }
                ) {
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            it
                        )) {

                    }
                }
            }
        }
    }
}
