package ru.skfl.speechstream.config

import io.minio.BucketExistsArgs
import io.minio.MakeBucketArgs
import io.minio.MinioClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class MinioConfig(
    @Value("\${filestorage.minio.url}") val minioUrl: String,
    @Value("\${filestorage.minio.user}") val minioUser: String,
    @Value("\${filestorage.minio.password}") val minioPassword: String,
    @Value("\${filestorage.minio.default-bucket-name}") val defaultBucketName: String
) {

    @Bean
    fun minioClient(): MinioClient {
        var minioClient = MinioClient.builder()
            .endpoint(minioUrl)
            .credentials(minioUser, minioPassword)
            .build()
        createDefaultBucket(minioClient)
        return minioClient
    }

    private fun createDefaultBucket(minioClient: MinioClient) {
        if (!minioClient.bucketExists(
                BucketExistsArgs.builder()
                    .bucket(defaultBucketName)
                    .build()
            )
        ) {
            minioClient.makeBucket(
                MakeBucketArgs.builder()
                    .bucket(defaultBucketName)
                    .build()
            )
        }
    }
}