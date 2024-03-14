package ru.skfl.speechstream.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
class FileControllerImpl : FileController {

    override suspend fun upload(multipartFile: MultipartFile): String {
        TODO("Not yet implemented")
    }
}