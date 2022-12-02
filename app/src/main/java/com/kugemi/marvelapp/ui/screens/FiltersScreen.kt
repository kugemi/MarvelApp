package com.kugemi.marvelapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.kugemi.marvelapp.R
import com.kugemi.marvelapp.data.SortType
import com.kugemi.marvelapp.data.recources.*
import com.kugemi.marvelapp.ui.components.CustomButton
import com.kugemi.marvelapp.ui.components.FilterItem
import com.kugemi.marvelapp.viewmodels.CharactersViewModel

@Composable
fun FiltersScreen(
    navController: NavController,
    charactersViewModel: CharactersViewModel
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = filtersScreenPadding)
        ) {
            Icon(
                modifier = Modifier
                    .size(iconBackSize)
                    .offset(x = defaultPadding)
                    .clickable {
                        navController.popBackStack()
                    },
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = null,
                tint = iconBackColor
            )
            Text(
                modifier = Modifier.padding(start = filtersTextPadding),
                text = stringResource(id = R.string.filters),
                fontSize = fontFiltersText,
                fontWeight = FontWeight.Bold
            )
        }
        LazyColumn {
            items(SortType.values()) {
                FilterItem(
                    sortType = it,
                    charactersViewModel
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Bottom
        ) {
            CustomButton(
                text = stringResource(id = R.string.apply),
                modifier = Modifier.padding(bottom = filtersButtonPadding)
            ) {
                navController.popBackStack()
            }
        }
    }
}