package com.kugemi.marvelapp.utils

import com.kugemi.marvelapp.BuildConfig
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

object NetworkUtils {
    const val BASE_URL = "https://gateway.marvel.com:443/"
    val ts = Timestamp(System.currentTimeMillis()).time.toString()
    const val API_KEY = BuildConfig.API_KEY
    const val PRIVATE_KEY = BuildConfig.PRIVATE_KEY
    const val DEFAULT_LIMIT = 100

    fun generateMd5Hash(): String{
        val input = "$ts$PRIVATE_KEY$API_KEY"
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray()))
            .toString(16)
            .padStart(32, '0')
    }
}