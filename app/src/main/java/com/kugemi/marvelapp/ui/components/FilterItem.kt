package com.kugemi.marvelapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.kugemi.marvelapp.R
import com.kugemi.marvelapp.data.SortType
import com.kugemi.marvelapp.data.recources.*
import com.kugemi.marvelapp.viewmodels.CharactersViewModel

@Composable
fun FilterItem(
    sortType: SortType,
    charactersViewModel: CharactersViewModel
) {
    val currentSortType = charactersViewModel.sortType.observeAsState()

    var isSelected by remember { mutableStateOf(false) }

    currentSortType.value?.let {
        isSelected = sortType == it
    }

    Card(
        modifier = Modifier
            .padding(horizontal = filterItemPadding)
            .clickable {
                charactersViewModel.updateSortType(sortType)
            },
        shape = RoundedCornerShape(filterItemCorner),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        border = if (isSelected) {
            BorderStroke(
                width = filterItemBorderWidth,
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        filterItemBorderFirst,
                        filterItemBorderSecond
                    )
                )
            )
        } else {
            null
        }
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                modifier = Modifier
                    .weight(0.85f)
                    .padding(
                        vertical = filterItemTextVerticalPadding,
                        horizontal = filterItemTextHorizontalPadding
                    ),
                text = getSortTypeName(sortType),
                fontSize = fontFilterItem,
            ) 
            Icon(
                modifier = Modifier
                    .size(filterItemIconSize)
                    .weight(0.15f),
                imageVector = Icons.Filled.Check,
                contentDescription = null,
                tint = if (isSelected) {
                    filterItemIconColor
                } else {
                    filterItemIconColor.copy(alpha = 0.16f)
                }
            )
        }
    }
}

@Composable
private fun getSortTypeName(sortType: SortType): String {
    return when(sortType) {
        SortType.ALPHABET_ASCENDING -> stringResource(id = R.string.alphabet_ascending)
        SortType.ALPHABET_DESCENDING -> stringResource(id = R.string.alphabet_descending)
        SortType.DATE_ASCENDING -> stringResource(id = R.string.date_ascending)
        SortType.DATE_DESCENDING -> stringResource(id = R.string.date_descending)
    }
}