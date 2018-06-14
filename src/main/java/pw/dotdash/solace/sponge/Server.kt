@file:Suppress("NOTHING_TO_INLINE")

package pw.dotdash.solace.sponge

import org.spongepowered.api.Server
import org.spongepowered.api.Sponge
import org.spongepowered.api.entity.living.player.Player
import org.spongepowered.api.world.World
import org.spongepowered.api.world.WorldArchetype
import org.spongepowered.api.world.storage.WorldProperties
import pw.dotdash.solace.java.unwrapped
import java.util.*
import java.util.concurrent.CompletableFuture

inline val Server: Server
    get() = Sponge.getServer()

inline val UUID.player: Player?
    get() = Server.getPlayer(this).unwrapped
inline val String.player: Player?
    get() = Server.getPlayer(this).unwrapped

inline val UUID.world: World?
    get() = Server.getWorld(this).unwrapped
inline val String.world: World?
    get() = Server.getWorld(this).unwrapped

inline val UUID.worldProperties: WorldProperties?
    get() = Server.getWorldProperties(this).unwrapped
inline val String.worldProperties: WorldProperties?
    get() = Server.getWorldProperties(this).unwrapped

inline fun UUID.loadWorld(): World? =
        Server.loadWorld(this).unwrapped

inline fun String.loadWorld(): World? =
        Server.loadWorld(this).unwrapped

inline fun WorldProperties.loadWorld(): World? =
        Server.loadWorld(this).unwrapped

inline fun World.unload(): Boolean =
        Server.unloadWorld(this)

inline fun String.createWorldProperties(archetype: WorldArchetype): WorldProperties =
        Server.createWorldProperties(this, archetype)

inline fun WorldProperties.copy(copyName: String): CompletableFuture<WorldProperties> =
        Server.copyWorld(this, copyName).thenApply { it.unwrapped }

inline fun WorldProperties.rename(newName: String): WorldProperties? =
        Server.renameWorld(this, newName).unwrapped

inline fun WorldProperties.delete(): CompletableFuture<Boolean> =
        Server.deleteWorld(this)

inline fun WorldProperties.save(): Boolean =
        Server.saveWorldProperties(this)