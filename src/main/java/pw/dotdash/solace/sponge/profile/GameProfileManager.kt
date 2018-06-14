@file:Suppress("NOTHING_TO_INLINE")

package pw.dotdash.solace.sponge.profile

import org.spongepowered.api.Sponge
import org.spongepowered.api.profile.GameProfile
import org.spongepowered.api.profile.GameProfileManager
import java.util.*
import java.util.concurrent.CompletableFuture

inline val GameProfileManager: GameProfileManager
    get() = Sponge.getServer().gameProfileManager

inline fun UUID.createGameProfile(name: String?): GameProfile =
        GameProfileManager.createProfile(this, name)

inline val UUID.gameProfile: CompletableFuture<GameProfile>
    get() = GameProfileManager.get(this)

inline val String.gameProfile: CompletableFuture<GameProfile>
    get() = GameProfileManager.get(this)

inline val UUID.uncachedGameProfile: CompletableFuture<GameProfile>
    get() = GameProfileManager.get(this, false)

inline val String.uncachedGameProfile: CompletableFuture<GameProfile>
    get() = GameProfileManager.get(this, false)

inline val Iterable<UUID>.gameProfilesById: CompletableFuture<Collection<GameProfile>>
    get() = GameProfileManager.getAllById(this, true)

inline val Iterable<String>.gameProfilesByName: CompletableFuture<Collection<GameProfile>>
    get() = GameProfileManager.getAllByName(this, true)

inline fun GameProfile.fill(): CompletableFuture<GameProfile> =
        GameProfileManager.fill(this)

inline fun GameProfile.fill(signed: Boolean): CompletableFuture<GameProfile> =
        GameProfileManager.fill(this, signed)

inline fun GameProfile.fill(signed: Boolean, useCache: Boolean): CompletableFuture<GameProfile> =
        GameProfileManager.fill(this, signed, useCache)