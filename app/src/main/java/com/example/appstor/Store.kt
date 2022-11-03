package com.example.appstor

data class Store(
    var id: Int = 0,
    var name: String,
    var phone: String = "",
    var website: String = "",
    var isFavourite: Boolean = false
) {
}