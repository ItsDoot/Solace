@file:Suppress("NOTHING_TO_INLINE")

package solace.sponge.text.channel

import org.spongepowered.api.text.channel.MessageReceiver
import org.spongepowered.api.text.channel.MutableMessageChannel

inline operator fun MutableMessageChannel.plusAssign(member: MessageReceiver) {
    this.addMember(member)
}

inline operator fun MutableMessageChannel.minusAssign(member: MessageReceiver) {
    this.removeMember(member)
}