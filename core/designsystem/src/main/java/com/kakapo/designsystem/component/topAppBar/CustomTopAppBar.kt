package com.kakapo.designsystem.component.topAppBar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.kakapo.common.type.Func
import com.kakapo.designsystem.component.button.CustomIconButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppbar(title: String){
    Surface(shadowElevation = 2.dp, tonalElevation = 2.dp) {
        TopAppBar(title = { Text(text = title) })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDrawerTopAppBar(title: String, onClick: Func) {
    Surface(shadowElevation = 2.dp, tonalElevation = 2.dp) {
        TopAppBar(
            navigationIcon = { CustomIconButton(icon = Icons.Default.Menu, onClick = onClick) },
            title = { Text(text = title) }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomNavigationWithActionTopAppBar(
    title: String,
    actionIcon: @Composable (RowScope.() -> Unit),
    onBackClick: Func
) {
    Surface(shadowElevation = 2.dp, tonalElevation = 2.dp) {
        TopAppBar(
            navigationIcon = {
                CustomIconButton(icon = Icons.Default.ArrowBack, onClick = onBackClick)
            },
            title = { Text(text = title) },
            actions = actionIcon
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomNavigationTopAppbar(title: String, onNavigateBack: Func) {
    Surface(shadowElevation = 2.dp, tonalElevation = 2.dp) {
        TopAppBar(
            title = { Text(text = title) },
            navigationIcon = {
                CustomIconButton(icon = Icons.Default.ArrowBack, onClick = onNavigateBack)
            }
        )
    }
}

