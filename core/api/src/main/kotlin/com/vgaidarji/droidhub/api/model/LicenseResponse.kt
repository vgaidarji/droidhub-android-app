package com.vgaidarji.droidhub.api.model

import com.vgaidarji.droidhub.model.License
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LicenseResponse(
    @SerialName("key") val key: String?,
    @SerialName("name") val name: String?,
    @SerialName("spdx_id") val spdxId: String?,
    @SerialName("url") val url: String?,
    @SerialName("node_id") val nodeId: String?
) {
    fun toModel() = License(
        key = key ?: "",
        name = name ?: "",
    )
}
