package com.vgaidarji.droidhub.model

data class GitHubUserStatus(
    val emoji: String,
    // The status emoji as HTML.
    val emojiHtml: String,
    // An ISO-8601 encoded UTC date string.
    val expiresAt: String,
    // Whether this status indicates the user is not fully available on GitHub.
    val limitedAvailability: String,
    val message: String,
) {
    companion object {
        val NO_USER_STATUS = GitHubUserStatus(
            emoji = "",
            emojiHtml = "",
            expiresAt = "",
            limitedAvailability = "",
            message = ""
        )
    }
}
