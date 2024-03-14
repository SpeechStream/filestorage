package ru.skfl.speechstream.transaction

import org.jooq.DSLContext
import ru.skfl.speechstream.helper.JooqHelper.Companion.dslKey
import kotlin.coroutines.CoroutineContext

class DSLContextContextProvider(
    val dslContext: DSLContext,
    override val key: CoroutineContext.Key<DSLContextContextProvider> = dslKey
) : CoroutineContext.Element
