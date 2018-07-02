package solace.sponge.plugin

import org.spongepowered.api.Sponge
import org.spongepowered.api.plugin.PluginContainer
import org.spongepowered.api.plugin.PluginManager
import solace.java.util.unwrapped

inline val PluginManager: PluginManager
    get() = Sponge.getPluginManager()

inline val Any.pluginContainer: PluginContainer?
    get() = PluginManager.fromInstance(this).unwrapped

inline val String.pluginContainer: PluginContainer?
    get() = PluginManager.getPlugin(this).unwrapped

inline val String.pluginLoaded: Boolean
    get() = PluginManager.isLoaded(this)