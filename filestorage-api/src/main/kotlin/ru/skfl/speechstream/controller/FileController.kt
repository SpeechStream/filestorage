package ru.skfl.speechstream.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.multipart.MultipartFile

@Tag(name = "Контроллер загрузки файлов")
interface FileController {

    @PostMapping
    @Operation(description = "Загрузить файл")
    suspend fun upload(multipartFile: MultipartFile): String
}