package ru.skfl.speechstream.model

import java.util.UUID

data class File(
    val id: UUID,
    val name: String,
    val extension: String,
    val ownerId: UUID
) {
}