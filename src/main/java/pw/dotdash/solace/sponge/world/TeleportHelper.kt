@file:Suppress("NOTHING_TO_INLINE")

package pw.dotdash.solace.sponge.world

import org.spongepowered.api.Sponge
import org.spongepowered.api.world.Location
import org.spongepowered.api.world.TeleportHelper
import org.spongepowered.api.world.World
import org.spongepowered.api.world.teleport.TeleportHelperFilter
import pw.dotdash.solace.java.unwrapped

inline val TeleportHelper: TeleportHelper
    get() = Sponge.getTeleportHelper()

inline val Location<World>.safeLocation: Location<World>?
    get() = TeleportHelper.getSafeLocation(this).unwrapped

inline fun Location<World>.getSafeLocation(height: Int, width: Int): Location<World>? =
        TeleportHelper.getSafeLocation(this, height, width).unwrapped

inline fun Location<World>.getSafeLocation(height: Int, width: Int, floorDistance: Int): Location<World>? =
        TeleportHelper.getSafeLocation(this, height, width, floorDistance).unwrapped

inline fun Location<World>.getSafeLocation(height: Int, width: Int, floorDistance: Int, filter: TeleportHelperFilter,
                                           vararg moreFilters: TeleportHelperFilter): Location<World>? =
        TeleportHelper.getSafeLocation(this, height, width, floorDistance, filter, *moreFilters).unwrapped

inline fun Location<World>.getSafeLocationWithBlacklist(height: Int, width: Int, floorDistance: Int,
                                                        vararg filters: TeleportHelperFilter): Location<World>? =
        TeleportHelper.getSafeLocationWithBlacklist(this, height, width, floorDistance, *filters).unwrapped
