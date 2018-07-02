@file:Suppress("NOTHING_TO_INLINE")

package solace.sponge.service.whitelist

import org.spongepowered.api.profile.GameProfile
import org.spongepowered.api.service.whitelist.WhitelistService
import solace.sponge.service.service

inline val WhitelistService: WhitelistService?
    get() = org.spongepowered.api.service.whitelist.WhitelistService::class.java.service

inline val GameProfile.whitelisted: Boolean
    get() = WhitelistService?.isWhitelisted(this) ?: false

inline fun GameProfile.setWhitelisted(whitelisted: Boolean) =
        if (whitelisted) WhitelistService?.addProfile(this)
        else WhitelistService?.removeProfile(this)

inline operator fun WhitelistService.contains(profile: GameProfile): Boolean =
        this.isWhitelisted(profile)

inline operator fun WhitelistService.plusAssign(profile: GameProfile) {
    this.addProfile(profile)
}

inline operator fun WhitelistService.minusAssign(profile: GameProfile) {
    this.removeProfile(profile)
}