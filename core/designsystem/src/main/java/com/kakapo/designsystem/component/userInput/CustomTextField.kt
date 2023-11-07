package com.kakapo.designsystem.component.userInput

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.kakapo.common.type.Func
import com.kakapo.designsystem.theme.VipeTheme

@Composable
fun CustomOutlinedTextField(
    modifier: Modifier = Modifier,
    placeHolder: String,
    shape: Shape = MaterialTheme.shapes.medium,
    keyboardType: KeyboardOptions = KeyboardOptions.Default,
    leadingIcon: @Composable() (() -> Unit)? = null,
    trailingIcon: @Composable() (() -> Unit)? = null,
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        shape = shape,
        onValueChange = onValueChange,
        placeholder = {
            Text(text = placeHolder)
        },
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        colors = CustomTextFieldDefault.outLinedTextFieldColor(),
        keyboardOptions = keyboardType
    )
}

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    placeHolder: String,
    value: String,
    onValueChange: (String) -> Unit,
    textStyle: TextStyle = LocalTextStyle.current
) {
    TextField(
        modifier = modifier,
        placeholder = { Text(text = placeHolder, style = textStyle) },
        value = value,
        textStyle = textStyle,
        onValueChange = onValueChange,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun CustomClickAbleOutlinedTextField(
    modifier: Modifier = Modifier,
    placeHolder: String,
    trailingIcon: @Composable() (() -> Unit)? = null,
    value: String,
    onClick: Func
) {
    val interactionSource = remember { MutableInteractionSource() }
    OutlinedTextField(
        readOnly = true,
        modifier = modifier,
        value = value,
        shape = MaterialTheme.shapes.medium,
        onValueChange = {},
        placeholder = {
            Text(text = placeHolder)
        },
        maxLines = 1,
        trailingIcon = trailingIcon,
        colors = CustomTextFieldDefault.outLinedTextFieldColor(),
        interactionSource = interactionSource.also { interaction ->
            LaunchedEffect(key1 = interaction) {
                interaction.interactions.collect {
                    if (it is PressInteraction.Release) {
                        onClick.invoke()
                    }
                }
            }
        }
    )
}

object CustomTextFieldDefault {
    @Composable
    fun outLinedTextFieldColor() = TextFieldDefaults.colors(
        focusedContainerColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent,
        disabledContainerColor = Color.Transparent,
    )
}

@Preview
@Composable
private fun CustomTextFieldPrev() {
    VipeTheme {
        CustomTextField(placeHolder = "PlaceHolder", value = "", onValueChange = {})
    }
}