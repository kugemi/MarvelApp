package com.kugemi.marvelapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.kugemi.marvelapp.R
import com.kugemi.marvelapp.data.recources.filtersButtonBottomPadding
import com.kugemi.marvelapp.data.recources.filtersButtonPadding
import com.kugemi.marvelapp.ui.components.CharacterItem
import com.kugemi.marvelapp.ui.components.CustomButton
import com.kugemi.marvelapp.ui.navigation.NavRoutes
import com.kugemi.marvelapp.utils.sortedBySortType
import com.kugemi.marvelapp.viewmodels.CharactersViewModel
import java.util.*

@Composable
fun HomeScreen(
    navController: NavController,
    charactersViewModel: CharactersViewModel
) {
    val marvelResponse = charactersViewModel.marvelResponse.observeAsState()

    val sortType = charactersViewModel.sortType.observeAsState()

    marvelResponse.value?.let { marvelResponse ->
        sortType.value?.let { sortType ->
            Column {
                LazyColumn(
                    modifier = Modifier.weight(0.8f)
                ) {
                    items(marvelResponse.data.results.sortedBySortType(sortType)) {
                        CharacterItem(
                            result = it,
                            charactersViewModel = charactersViewModel,
                            navController = navController
                        )
                    }
                }
                CustomButton(
                    text = stringResource(id = R.string.filters).uppercase(Locale.getDefault()),
                    modifier = Modifier
                        .padding
                            (top = filtersButtonPadding,
                            bottom = filtersButtonBottomPadding
                        )
                        .weight(0.2f)
                ) {
                    navController.navigate(NavRoutes.Filters.route)
                }
            }
        }
    }
}