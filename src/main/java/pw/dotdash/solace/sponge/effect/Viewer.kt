@file:Suppress("NOTHING_TO_INLINE")

package pw.dotdash.solace.sponge.effect

import com.flowpowered.math.vector.Vector3d
import org.spongepowered.api.effect.Viewer
import org.spongepowered.api.effect.particle.ParticleEffect
import org.spongepowered.api.effect.sound.SoundCategory
import org.spongepowered.api.effect.sound.SoundType
import org.spongepowered.api.text.BookView
import org.spongepowered.api.text.title.Title

inline fun ParticleEffect.spawnFor(viewer: Viewer, position: Vector3d) =
        viewer.spawnParticles(this, position)

inline fun ParticleEffect.spawnFor(viewer: Viewer, position: Vector3d, radius: Int) =
        viewer.spawnParticles(this, position, radius)

inline fun SoundType.playFor(viewer: Viewer, position: Vector3d, volume: Double) =
        viewer.playSound(this, position, volume)

inline infix fun SoundType.stopFor(viewer: Viewer) =
        viewer.stopSounds(this)

inline infix fun SoundCategory.stopFor(viewer: Viewer) =
        viewer.stopSounds(this)

inline infix fun Title.sendTo(viewer: Viewer) =
        viewer.sendTitle(this)

inline infix fun BookView.sendTo(viewer: Viewer) =
        viewer.sendBookView(this)