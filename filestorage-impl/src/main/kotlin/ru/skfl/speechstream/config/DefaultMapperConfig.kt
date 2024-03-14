package ru.skfl.speechstream.config

import org.mapstruct.*

@Mapper(
    componentModel = "spring",
    builder = Builder(disableBuilder = true),
    unmappedSourcePolicy = ReportingPolicy.ERROR,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
interface DefaultMapperConfig