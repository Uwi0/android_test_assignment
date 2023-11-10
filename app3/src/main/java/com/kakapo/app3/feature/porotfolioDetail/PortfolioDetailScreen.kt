package com.kakapo.app3.feature.porotfolioDetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
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
import com.kakapo.common.type.Func
import com.kakapo.designsystem.component.topAppBar.CustomNavigationTopAppbar
import com.kakapo.designsystem.component.topAppBar.CustomTopAppbar

@Composable
fun PortfolioDetailRoute(viewModel: PortfolioDetailViewModel = hiltViewModel(), onNavBack: Func) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    PortfolioDetailScreen(uiState = uiState, onNavBack = onNavBack)
}

@Composable
fun PortfolioDetailScreen(uiState: PortfolioDetailUiState, onNavBack: Func) {
    Scaffold(
        topBar = {
            CustomNavigationTopAppbar(
                title = stringResource(id = R.string.portfolio_detail),
                onNavigateBack = onNavBack
            )
        },
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingValues),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 24.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                content = {
                    items(uiState.detailItems) { item ->
                        ListItem(
                            modifier = Modifier.fillMaxWidth(),
                            tonalElevation = 2.dp,
                            headlineContent = { Text(text = item.trxDate) },
                            supportingContent = { Text(text = "${item.nominal}") }
                        )
                    }
                }
            )
        }
    )
}