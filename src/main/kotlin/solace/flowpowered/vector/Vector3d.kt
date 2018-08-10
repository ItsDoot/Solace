@file:Suppress("NOTHING_TO_INLINE")

package solace.flowpowered.vector

import com.flowpowered.math.vector.Vector3d

inline fun Vector3d.with(x: Double = this.x, y: Double = this.y, z: Double = this.z): Vector3d =
        Vector3d(x, y, z)

inline operator fun Vector3d.times(that: Vector3d): Vector3d = this.mul(that)
inline operator fun Vector3d.plus(that: Vector3d): Vector3d = this.add(that)
inline operator fun Vector3d.minus(that: Vector3d): Vector3d = this.min(that)

inline operator fun Vector3d.unaryPlus(): Vector3d = Vector3d(if (x < 0) -x else x, if (y < 0) -y else y, if (z < 0) -z else z)
inline operator fun Vector3d.unaryMinus(): Vector3d = this.negate()
