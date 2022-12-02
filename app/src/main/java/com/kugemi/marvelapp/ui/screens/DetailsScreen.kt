package com.kugemi.marvelapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.kugemi.marvelapp.data.recources.*
import com.kugemi.marvelapp.viewmodels.CharactersViewModel

@Composable
fun DetailsScreen(
    navController: NavController,
    charactersViewModel: CharactersViewModel
) {
    val currentCharacter = charactersViewModel.currentCharacter.observeAsState()

    currentCharacter.value?.let { currentCharacter ->
        Column(modifier = Modifier.fillMaxWidth()) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop,
                painter = rememberAsyncImagePainter(
                    "${currentCharacter.thumbnail.path}.${currentCharacter.thumbnail.extension}"
                ),
                contentDescription = null,
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                    top = detailsScreenPadding,
                    bottom = detailsScreenBottomPadding,
                    start = detailsScreenPadding,
                    end = detailsScreenPadding
                ),
                text = currentCharacter.name,
                fontSize = fontCharacterDetailsName,
                fontWeight = FontWeight.Bold,
                lineHeight = fontCharacterDetailsNameLineHeight
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = detailsScreenPadding,
                        end = defaultPadding
                    ),
                text = currentCharacter.description,
                fontSize = fontCharacterDetailsDescription,
                lineHeight = fontCharacterDetailsDescriptionLineHeight
            )
        }
    }
}