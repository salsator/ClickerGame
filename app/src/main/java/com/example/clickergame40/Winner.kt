package com.example.clickergame40

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Winner(val name: String? = null, val score: String? = null) {


}