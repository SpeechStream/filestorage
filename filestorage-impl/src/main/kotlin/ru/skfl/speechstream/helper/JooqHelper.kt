package ru.skfl.speechstream.helper

import org.jooq.DSLContext
import ru.skfl.speechstream.transaction.DSLContextContextProvider
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

class JooqHelper(
    private val dslContext: DSLContext
) {

    suspend fun getCtx() : DSLContext = coroutineContext[dslKey]?.dslContext ?: this.dslContext

    companion object {
        @JvmStatic
        val dslKey = object : CoroutineContext.Key<DSLContextContextProvider> {}
    }
}
