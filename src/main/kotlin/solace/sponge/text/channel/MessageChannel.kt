@file:Suppress("NOTHING_TO_INLINE")

package solace.sponge.text.channel

import org.spongepowered.api.text.Text
import org.spongepowered.api.text.channel.MessageChannel
import org.spongepowered.api.text.channel.MessageReceiver
import org.spongepowered.api.text.chat.ChatType
import org.spongepowered.api.world.World

inline val String.permissionChannel: MessageChannel
    get() = MessageChannel.permission(this)

inline val Array<MessageChannel>.combinedChannel: MessageChannel
    get() = MessageChannel.combined(*this)
inline val Collection<MessageChannel>.combinedChannel: MessageChannel
    get() = MessageChannel.combined(this)

inline val Array<MessageReceiver>.fixedChannel: MessageChannel
    get() = MessageChannel.fixed(*this)
inline val Collection<MessageReceiver>.fixedChannel: MessageChannel
    get() = MessageChannel.fixed(this)

inline val World.channel: MessageChannel
    get() = MessageChannel.world(this)

inline operator fun MessageChannel.invoke(original: Text) =
        this.send(original)

inline operator fun MessageChannel.invoke(original: Text, type: ChatType) =
        this.send(original, type)

inline operator fun MessageChannel.invoke(sender: Any?, original: Text) =
        this.send(sender, original)

inline operator fun MessageChannel.invoke(sender: Any?, original: Text, type: ChatType) =
        this.send(sender, original, type)

inline operator fun MessageChannel.contains(member: MessageReceiver): Boolean =
        member in this.members

inline operator fun MessageChannel.iterator(): Iterable<MessageReceiver> =
        this.members