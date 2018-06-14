@file:Suppress("NOTHING_TO_INLINE")

package pw.dotdash.solace.sponge.asset

import org.spongepowered.api.Sponge
import org.spongepowered.api.asset.Asset
import org.spongepowered.api.asset.AssetManager
import pw.dotdash.solace.java.unwrapped

inline val AssetManager: AssetManager
    get() = Sponge.getAssetManager()

inline fun Any.asset(name: String): Asset? =
        AssetManager.getAsset(this, name).unwrapped

inline val String.asset: Asset?
    get() = AssetManager.getAsset(this).unwrapped