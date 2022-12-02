package com.kugemi.marvelapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.kugemi.marvelapp.data.recources.*
import com.kugemi.marvelapp.ui.navigation.NavRoutes
import com.kugemi.marvelapp.viewmodels.CharactersViewModel

@Composable
fun CharacterItem(
    result: com.kugemi.marvelapp.model.Result,
    charactersViewModel: CharactersViewModel,
    navController: NavController
) {
    Row(
        modifier = Modifier
            .clickable {
                charactersViewModel.updateCurrentCharacter(result)
                navController.navigate(NavRoutes.Details.route)
            }
            .padding(vertical = characterItemPadding)
    ) {
        Image(
            painter = rememberAsyncImagePainter("${result.thumbnail.path}.${result.thumbnail.extension}"),
            contentDescription = null,
            modifier = Modifier
                .size(characterItemImageSize)
                .padding(characterItemPadding)
        )
        Column(modifier = Modifier.padding(characterItemPadding)) {
            Text(
                modifier = Modifier.padding(bottom = defaultPadding),
                text = result.name,
                fontSize = fontCharacterItemName,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = result.description,
                fontSize = fontCharacterItemDescription,
                maxLines = 4,
                overflow = TextOverflow.Ellipsis,
                lineHeight = characterItemLineHeight
            )
        }
    }
}