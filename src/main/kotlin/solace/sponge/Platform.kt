package solace.sponge

import org.spongepowered.api.Platform
import org.spongepowered.api.Sponge
import org.spongepowered.api.plugin.PluginContainer

inline val Platform: Platform
    get() = Sponge.getPlatform()

inline val Platform.Component.container: PluginContainer
    get() = Platform.getContainer(this)

