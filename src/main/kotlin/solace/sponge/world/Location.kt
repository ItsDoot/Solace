@file:Suppress("NOTHING_TO_INLINE")

package solace.sponge.world

import org.spongepowered.api.world.Locatable
import org.spongepowered.api.world.Location
import org.spongepowered.api.world.World

inline fun <T : Locatable> Iterable<T>.nearest(location: Location<World>): T? =
        this.filter {
            it.world.uniqueId == location.extent.uniqueId
        }.minBy {
            it.location.position.distance(location.position)
        }