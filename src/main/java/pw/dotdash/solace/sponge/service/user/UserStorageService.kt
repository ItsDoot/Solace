@file:Suppress("NOTHING_TO_INLINE")

package pw.dotdash.solace.sponge.service.user

import org.spongepowered.api.entity.living.player.User
import org.spongepowered.api.profile.GameProfile
import org.spongepowered.api.service.user.UserStorageService
import pw.dotdash.solace.java.unwrapped
import pw.dotdash.solace.sponge.service.uncheckedService
import java.util.*

inline val UserStorageService: UserStorageService
    get() = org.spongepowered.api.service.user.UserStorageService::class.java.uncheckedService

inline val UUID.user: User?
    get() = UserStorageService.get(this).unwrapped

inline val String.user: User?
    get() = UserStorageService.get(this).unwrapped

inline val GameProfile.user: User?
    get() = UserStorageService.get(this).unwrapped

inline fun GameProfile.getOrCreateUser(): User =
        UserStorageService.getOrCreate(this)

inline fun GameProfile.deleteUser(): Boolean =
        UserStorageService.delete(this)

inline fun User.delete(): Boolean =
        UserStorageService.delete(this)

inline fun String.matchGameProfile(): Collection<GameProfile> =
        UserStorageService.match(this)