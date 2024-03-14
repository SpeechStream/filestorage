package ru.skfl.speechstream.config

import io.r2dbc.spi.ConnectionFactory
import org.jooq.DSLContext
import org.jooq.SQLDialect
import org.jooq.conf.Settings
import org.jooq.impl.DSL
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JooqConfig {

    @Bean
    fun reactiveDSLContext(connectionFactory: ConnectionFactory): DSLContext =
        DSL.using(
            connectionFactory,
            SQLDialect.POSTGRES,
            Settings()
                .withExecuteWithOptimisticLocking(true)
                .withExecuteWithOptimisticLockingExcludeUnversioned(true)
        )
}