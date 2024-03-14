package ru.skfl.speechstream.repository.impl

import kotlinx.coroutines.reactive.awaitFirst
import kotlinx.coroutines.reactive.awaitFirstOrNull
import mapper.record.FileRecordMapper
import org.jooq.generated.tables.records.FileRecord
import ru.skfl.speechstream.helper.JooqHelper
import ru.skfl.speechstream.model.File
import ru.skfl.speechstream.repository.FileRepository
import java.util.*

class FileRepositoryImpl(
    private val jooqHelper: JooqHelper,
    private val fileRecordMapper: FileRecordMapper
) : FileRepository {

    override suspend fun save(file: File): File =
        jooqHelper.getCtx()
            .insertInto(
                org.jooq.generated.tables.File.FILE,
                org.jooq.generated.tables.File.FILE.NAME,
                org.jooq.generated.tables.File.FILE.OWNER_ID,
                org.jooq.generated.tables.File.FILE.EXTENSION,
            )
            .values(
                file.name,
                file.ownerId,
                file.extension
            )
            .returning()
            .awaitFirst()
            .let { fileRecordMapper.map(it) }


    override suspend fun findById(id: UUID): File? =
        jooqHelper.getCtx()
            .select(org.jooq.generated.tables.File.FILE)
            .where(org.jooq.generated.tables.File.FILE.ID.eq(id))
            .awaitFirstOrNull()
            ?.let { fileRecordMapper.map(it) }

    override suspend fun deleteById(id: UUID) {
        TODO("Not yet implemented")
    }
}