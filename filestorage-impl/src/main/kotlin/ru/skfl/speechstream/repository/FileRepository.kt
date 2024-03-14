package ru.skfl.speechstream.repository

import ru.skfl.speechstream.model.File
import java.util.*

interface FileRepository {

    suspend fun save(file : File) : File

    suspend fun findById(id : UUID) : File?

    suspend fun deleteById(id : UUID)
}