package com.kugemi.marvelapp.utils

import com.kugemi.marvelapp.data.SortType
import java.time.ZonedDateTime

fun List<com.kugemi.marvelapp.model.Result>.sortedBySortType(type: SortType): List<com.kugemi.marvelapp.model.Result> {
    return when (type) {
        SortType.ALPHABET_ASCENDING -> sortedBy { it.name }
        SortType.ALPHABET_DESCENDING -> sortedByDescending { it.name }
        SortType.DATE_ASCENDING -> sortedBy {
            ZonedDateTime.parse(it.modified.dropLast(5) + "Z")
        }
        SortType.DATE_DESCENDING -> sortedByDescending {
            ZonedDateTime.parse(it.modified.dropLast(5) + "Z")
        }
    }
}