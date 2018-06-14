@file:Suppress("NOTHING_TO_INLINE")

package pw.dotdash.solace.sponge.network

import org.spongepowered.api.Platform
import org.spongepowered.api.Sponge
import org.spongepowered.api.network.ChannelBinding
import org.spongepowered.api.network.ChannelRegistrar
import pw.dotdash.solace.java.unwrapped

inline val ChannelRegistrar: ChannelRegistrar
    get() = Sponge.getChannelRegistrar()

inline fun Any.createChannel(channel: String): ChannelBinding.IndexedMessageChannel =
        ChannelRegistrar.createChannel(this, channel)

inline fun Any.createRawChannel(channel: String): ChannelBinding.RawDataChannel =
        ChannelRegistrar.createRawChannel(this, channel)

inline val String.channel: ChannelBinding?
    get() = ChannelRegistrar.getChannel(this).unwrapped

inline fun Any.getOrCreateChannel(channel: String): ChannelBinding.IndexedMessageChannel =
        ChannelRegistrar.getOrCreate(this, channel)

inline fun Any.getOrCreateRawChannel(channel: String): ChannelBinding.RawDataChannel =
        ChannelRegistrar.getOrCreateRaw(this, channel)

inline fun ChannelBinding.unbind() =
        ChannelRegistrar.unbindChannel(this)

inline val Platform.Type.registeredChannels: Set<String>
    get() = ChannelRegistrar.getRegisteredChannels(this)

inline val String.channelAvailable: Boolean
    get() = ChannelRegistrar.isChannelAvailable(this)