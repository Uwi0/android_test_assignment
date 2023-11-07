package com.kakapo.designsystem.component.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kakapo.designsystem.ThemePreviews
import com.kakapo.designsystem.theme.AppTheme

@Composable
fun CustomSwitchButton(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Switch(
        modifier = modifier,
        checked = checked,
        onCheckedChange = onCheckedChange
    )
}

@ThemePreviews
@Composable
private fun CustomToggleButtonPrev() {
    AppTheme {
        CustomSwitchButton(modifier = Modifier.fillMaxWidth(), checked = true) {}
    }
}