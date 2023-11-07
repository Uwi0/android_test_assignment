package com.kakapo.miitest.feature.home.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.kakapo.common.type.Func
import com.kakapo.designsystem.component.button.CustomButton
import com.kakapo.miitest.R

@Composable
internal fun DialogTransactionConfirmation(onDismiss: Func, onConfirm: Func) {
    AlertDialog(
        shape = MaterialTheme.shapes.medium,
        onDismissRequest = onDismiss,
        confirmButton = {
            CustomButton(
                onClick = { onConfirm.invoke(); onDismiss.invoke() },
                content = { Text(text = stringResource(id = R.string.confirm)) }
            )
        },
        dismissButton = {
            CustomButton(
                onClick = onDismiss,
                content = { Text(text = stringResource(id = com.kakapo.ui.R.string.cancel)) }
            )
        },
        text = { Text(text = stringResource(id = R.string.transaction_confirmation))}
    )
}