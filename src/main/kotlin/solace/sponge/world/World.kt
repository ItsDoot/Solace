@file:Suppress("NOTHING_TO_INLINE")

package solace.sponge.world

import com.flowpowered.math.vector.Vector3d
import com.flowpowered.math.vector.Vector3i
import org.spongepowered.api.entity.Entity
import org.spongepowered.api.world.Location
import org.spongepowered.api.world.World
import org.spongepowered.api.world.explosion.Explosion
import solace.java.util.unwrapped
import java.util.*

inline operator fun World.get(position: Vector3i): Location<World> =
        this.getLocation(position)

inline operator fun World.get(x: Int, y: Int, z: Int): Location<World> =
        this.getLocation(x, y, z)

inline operator fun World.get(position: Vector3d): Location<World> =
        this.getLocation(position)

inline operator fun World.get(x: Double, y: Double, z: Double): Location<World> =
        this.getLocation(x, y, z)

inline operator fun World.get(uuid: UUID): Entity? =
        this.getEntity(uuid).unwrapped

inline fun UUID.entity(world: World): Entity? =
        world.getEntity(this).unwrapped

inline fun Explosion.trigger(world: World) =
        world.triggerExplosion(this)