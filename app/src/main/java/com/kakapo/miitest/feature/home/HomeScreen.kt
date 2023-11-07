package com.kakapo.miitest.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kakapo.common.type.Func
import com.kakapo.common.utils.showLongToast
import com.kakapo.designsystem.component.topAppBar.CustomTopAppbar
import com.kakapo.miitest.R
import com.kakapo.miitest.feature.home.component.DialogTransactionConfirmation

@Composable
fun HomeRoute(viewModel: HomeViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    LaunchedEffect(key1 = Unit) {
        viewModel.uiSideEffect.collect { effect ->
            when (effect){
                is ShowError -> context.showLongToast(effect.message)
            }
        }
    }

    HomeScreen(uiState = uiState, onAddTransaction = viewModel::scanQrCode)

    if (uiState.isDialogVisible) {
        DialogTransactionConfirmation(
            onDismiss = {},
            onConfirm = {}
        )
    }
}

@Composable
fun HomeScreen(uiState: HomeUiState, onAddTransaction: Func) {
    Scaffold(
        topBar = {
            CustomTopAppbar(title = stringResource(id = R.string.app_name))
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .padding(horizontal = 16.dp, vertical = 24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = stringResource(id = R.string.your_balance)
                )
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = stringResource(id = R.string.currency, uiState.initialBalance),
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.size(2.dp))
                Text(text = stringResource(id = R.string.history_transaction))
                LazyColumn(
                    content = {
                        items(uiState.transactionHistories) { transaction ->

                        }
                    }
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddTransaction) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "")
                    Text(text = stringResource(id = R.string.add_transaction))
                }
            }
        }
    )
}