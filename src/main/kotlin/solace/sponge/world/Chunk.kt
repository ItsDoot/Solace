@file:Suppress("NOTHING_TO_INLINE")

package solace.sponge.world

import com.flowpowered.math.vector.Vector3d
import com.flowpowered.math.vector.Vector3i
import org.spongepowered.api.util.Direction
import org.spongepowered.api.world.Chunk
import org.spongepowered.api.world.Location
import solace.java.util.unwrapped

inline operator fun Chunk.get(position: Vector3i): Location<Chunk> =
        this.getLocation(position)

inline operator fun Chunk.get(x: Int, y: Int, z: Int): Location<Chunk> =
        this.getLocation(x, y, z)

inline operator fun Chunk.get(position: Vector3d): Location<Chunk> =
        this.getLocation(position)

inline operator fun Chunk.get(x: Double, y: Double, z: Double): Location<Chunk> =
        this.getLocation(x, y, z)

inline fun Direction.neighbor(chunk: Chunk): Chunk? =
        chunk.getNeighbor(this).unwrapped