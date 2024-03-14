package mapper.record

import org.jooq.Record
import org.jooq.generated.tables.records.FileRecord
import org.mapstruct.Mapper
import ru.skfl.speechstream.config.DefaultMapperConfig
import ru.skfl.speechstream.model.File

@Mapper(config = DefaultMapperConfig::class)
interface FileRecordMapper {

    fun map(fileRecord: FileRecord): File

    fun map(record: Record): File = map(record.into(FileRecord::class.java))
}