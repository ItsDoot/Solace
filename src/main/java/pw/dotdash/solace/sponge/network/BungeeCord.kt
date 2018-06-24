@file:Suppress("NOTHING_TO_INLINE")

package pw.dotdash.solace.sponge.network

import org.spongepowered.api.Server
import org.spongepowered.api.entity.living.player.Player
import org.spongepowered.api.text.Text
import pw.dotdash.solace.sponge.text.toLegacy

inline fun Player.sendBungeeConnect(plugin: Any, server: String) {
    plugin.getOrCreateRawChannel("BungeeCord").sendTo(this) { buf ->
        buf.writeUTF("Connect").writeUTF(server)
    }
}

inline fun Server.sendBungeeConnect(plugin: Any, player: String, server: String) {
    plugin.getOrCreateRawChannel("BungeeCord").sendTo(this.onlinePlayers.first()) { buf ->
        buf.writeUTF("ConnectOther").writeUTF(player).writeUTF(server)
    }
}

inline fun Server.sendBungeeMessage(plugin: Any, player: String, message: Text) {
    plugin.getOrCreateRawChannel("BungeeCord").sendTo(this.onlinePlayers.first()) { buf ->
        buf.writeUTF("Message").writeUTF(player).writeUTF(message.toLegacy())
    }
}

inline fun Server.sendBungeeKick(plugin: Any, player: String, reason: Text) {
    plugin.getOrCreateRawChannel("BungeeCord").sendTo(this.onlinePlayers.first()) { buf ->
        buf.writeUTF("KickPlayer").writeUTF(player).writeUTF(reason.toLegacy())
    }
}