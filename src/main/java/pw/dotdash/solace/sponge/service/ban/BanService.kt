@file:Suppress("NOTHING_TO_INLINE")

package pw.dotdash.solace.sponge.service.ban

import org.spongepowered.api.profile.GameProfile
import org.spongepowered.api.service.ban.BanService
import org.spongepowered.api.util.ban.Ban
import pw.dotdash.solace.java.unwrapped
import pw.dotdash.solace.sponge.service.service
import java.net.InetAddress

inline val BanService: BanService?
    get() = org.spongepowered.api.service.ban.BanService::class.java.service

inline val GameProfile.ban: Ban.Profile?
    get() = BanService?.getBanFor(this)?.unwrapped

inline val InetAddress.ban: Ban.Ip?
    get() = BanService?.getBanFor(this)?.unwrapped

inline val GameProfile.banned: Boolean
    get() = BanService?.isBanned(this) ?: false

inline val InetAddress.banned: Boolean
    get() = BanService?.isBanned(this) ?: false

inline fun GameProfile.pardon(): Boolean =
        BanService?.pardon(this) ?: false

inline fun InetAddress.pardon(): Boolean =
        BanService?.pardon(this) ?: false

inline fun Ban.remove(): Boolean =
        BanService?.removeBan(this) ?: false

inline fun Ban.add(): Ban? =
        BanService?.addBan(this)?.unwrapped

inline val Ban.set: Boolean
    get() = BanService?.hasBan(this) ?: false

inline operator fun BanService.get(profile: GameProfile): Ban.Profile? =
        this.getBanFor(profile).unwrapped

inline operator fun BanService.get(address: InetAddress): Ban.Ip? =
        this.getBanFor(address).unwrapped

inline operator fun BanService.contains(profile: GameProfile): Boolean =
        this.isBanned(profile)

inline operator fun BanService.contains(address: InetAddress): Boolean =
        this.isBanned(address)

inline operator fun BanService.minusAssign(profile: GameProfile) {
    this.pardon(profile)
}

inline operator fun BanService.minusAssign(address: InetAddress) {
    this.pardon(address)
}

inline operator fun BanService.minusAssign(ban: Ban) {
    this.removeBan(ban)
}

inline operator fun BanService.plusAssign(ban: Ban) {
    this.addBan(ban)
}

inline operator fun BanService.contains(ban: Ban): Boolean = this.hasBan(ban)