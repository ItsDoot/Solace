@file:Suppress("NOTHING_TO_INLINE")

package pw.dotdash.solace.sponge.service.economy

import org.spongepowered.api.service.economy.EconomyService
import org.spongepowered.api.service.economy.account.Account
import org.spongepowered.api.service.economy.account.UniqueAccount
import pw.dotdash.solace.java.unwrapped
import pw.dotdash.solace.sponge.service.service
import java.util.*

inline val EconomyService: EconomyService?
    get() = org.spongepowered.api.service.economy.EconomyService::class.java.service

inline val UUID.hasAccount: Boolean
    get() = EconomyService?.hasAccount(this) ?: false

inline val String.hasAccount: Boolean
    get() = EconomyService?.hasAccount(this) ?: false

inline val UUID.account: UniqueAccount?
    get() = EconomyService?.getOrCreateAccount(this)?.unwrapped

inline val String.account: Account?
    get() = EconomyService?.getOrCreateAccount(this)?.unwrapped

inline operator fun EconomyService.contains(uuid: UUID): Boolean =
        this.hasAccount(uuid)

inline operator fun EconomyService.contains(identifier: String): Boolean =
        this.hasAccount(identifier)

inline operator fun EconomyService.get(uuid: UUID): UniqueAccount? =
        this.getOrCreateAccount(uuid).unwrapped

inline operator fun EconomyService.get(identifier: String): Account? =
        this.getOrCreateAccount(identifier).unwrapped