package com.kakapo.designsystem.component.userInput

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> CustomExposedMenuTextField(
    items: List<T>,
    title: String,
    placeholder: String,
    textContent: @Composable (T) -> Unit,
    onClicked: (T) -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }
    val hideMenu = { isExpanded = false }

    ExposedDropdownMenuBox(expanded = isExpanded, onExpandedChange = { isExpanded = !isExpanded }) {
        OutlinedTextField(
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth(),
            value = title,
            placeholder = { Text(text = placeholder) },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
            onValueChange = {},
            readOnly = true,
            colors = CustomTextFieldDefault.outLinedTextFieldColor(),
            shape = MaterialTheme.shapes.medium
        )
        ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = hideMenu) {
            items.forEach {
                DropdownMenuItem(
                    text = { textContent.invoke(it) },
                    onClick = {
                        hideMenu.invoke()
                        onClicked.invoke(it)
                    }
                )
            }
        }
    }
}