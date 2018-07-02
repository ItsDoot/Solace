@file:Suppress("NOTHING_TO_INLINE")

package solace.sponge.service.sql

import org.spongepowered.api.service.sql.SqlService
import solace.java.util.unwrapped
import solace.sponge.service.service
import javax.sql.DataSource

inline val SqlService: SqlService?
    get() = org.spongepowered.api.service.sql.SqlService::class.java.service

inline val String.dataSource: DataSource?
    get() = SqlService?.getDataSource(this)

inline fun Any.dataSource(jdbc: String): DataSource? =
        SqlService?.getDataSource(this, jdbc)

inline val String.aliasConnectionUrl: String?
    get() = SqlService?.getConnectionUrlFromAlias(this)?.unwrapped