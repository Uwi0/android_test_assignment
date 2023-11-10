package com.kakapo.app3.feature.portfolios

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kakapo.app3.R
import com.kakapo.common.type.Fun
import com.kakapo.designsystem.component.topAppBar.CustomTopAppbar

@Composable
internal fun PortfoliosRoute(viewModel: PortfoliosViewModel = hiltViewModel(), onItemClick: Fun<String, Unit>) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    PortfoliosScreen(uiState = uiState, onItemClick = onItemClick)
}

@Composable
internal fun PortfoliosScreen(uiState: PortfolioUiState, onItemClick: Fun<String, Unit>) {
    Scaffold(
        topBar = {
            CustomTopAppbar(title = stringResource(id = R.string.app_name))
        },
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 24.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                content = {
                    items(uiState.portfolios) { item ->
                        ListItem(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { onItemClick.invoke(item.label) },
                            headlineContent = { Text(text = item.label) },
                            supportingContent = { Text(text = item.percentage) },
                            tonalElevation = 2.dp
                        )
                    }
                }
            )
        }
    )
}