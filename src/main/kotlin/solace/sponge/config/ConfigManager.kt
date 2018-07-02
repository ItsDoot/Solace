package solace.sponge.config

import org.spongepowered.api.Sponge
import org.spongepowered.api.config.ConfigManager
import org.spongepowered.api.config.ConfigRoot

inline val ConfigManager: ConfigManager
    get() = Sponge.getConfigManager()

inline val Any.sharedConfig: ConfigRoot
    get() = ConfigManager.getSharedConfig(this)

inline val Any.pluginConfig: ConfigRoot
    get() = ConfigManager.getPluginConfig(this)