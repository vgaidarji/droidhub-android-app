package com.vgaidarji.droidhub.model

data class RepositoryOwner(
    val id: Int,
    val login: String,
    val avatarUrl: String,
    val url: String
) {
    companion object {
        val EMPTY = RepositoryOwner(
            id = -1,
            login = "",
            avatarUrl = "",
            url = ""
        )
    }
}
