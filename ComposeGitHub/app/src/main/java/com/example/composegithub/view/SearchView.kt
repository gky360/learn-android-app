package com.example.composegithub.view

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchView(
    searchQuery: MutableState<String>,
    onSearchButtonTapped: () -> Unit,
) {
    Row(Modifier.fillMaxWidth()) {
        TextField(
            label = {
                Text(text = "GitHub のアカウントを入力")
            },
            value = searchQuery.value,
            onValueChange = { text -> searchQuery.value = text },
            modifier = Modifier.weight(1f)
        )
        Button(
            onClick = {
                onSearchButtonTapped()
            }
        ) {
            Text(text = "検索")
        }
    }
}
