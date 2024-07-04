package com.vgaidarji.droidhub.model

data class License(
    val key: String,
    val name: String,
) {
    companion object {
        val EMPTY = License(
            key = "",
            name = ""
        )
    }
}
