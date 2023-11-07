package com.kakapo.designsystem.component.tabs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kakapo.designsystem.ThemePreviews
import com.kakapo.designsystem.theme.AppTheme

@Composable
fun CustomTab(
    modifier: Modifier = Modifier,
    selected: Boolean,
    onClick: () -> Unit,
    text: @Composable () -> Unit
) {
    Tab(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        text = {
            val style = MaterialTheme.typography.labelLarge.copy(textAlign = TextAlign.Center)
            ProvideTextStyle(
                value = style,
                content = {
                    Box(modifier = Modifier.padding(top = CustomTabDefaults.TabTopPadding)) {
                        text.invoke()
                    }
                },
            )
        }
    )
}

@Composable
fun CustomTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    tabs: @Composable () -> Unit
) {
    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier,
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onSurface,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                height = 2.dp,
                color = MaterialTheme.colorScheme.onSurface,
            )
        },
        tabs = tabs,
    )
}

@ThemePreviews
@Composable
fun TabsPreview() {
    AppTheme {
        val titles = listOf("TabA", "TabB")
        Surface {
            CustomTabRow(selectedTabIndex = 0) {
                titles.forEachIndexed { index, s ->
                    CustomTab(selected = index == 0, onClick = { }) {
                        Text(text = s)
                    }
                }
            }
        }
    }
}

object CustomTabDefaults {
    val TabTopPadding = 7.dp
}
