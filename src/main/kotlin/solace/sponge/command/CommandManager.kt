@file:Suppress("NOTHING_TO_INLINE")

package solace.sponge.command

import org.spongepowered.api.Sponge
import org.spongepowered.api.command.*
import org.spongepowered.api.plugin.PluginContainer
import org.spongepowered.api.world.Location
import org.spongepowered.api.world.World
import solace.java.util.unwrapped

inline val CommandManager: CommandManager
    get() = Sponge.getCommandManager()

inline fun Any.registerCommand(callable: CommandCallable, vararg alias: String): CommandMapping? =
        CommandManager.register(this, callable, *alias).unwrapped

inline fun Any.registerCommand(callable: CommandCallable, aliases: List<String>): CommandMapping? =
        CommandManager.register(this, callable, aliases).unwrapped

inline fun Any.registerCommand(callable: CommandCallable, aliases: List<String>, noinline callback: (List<String>) -> List<String>): CommandMapping? =
        CommandManager.register(this, callable, aliases, callback).unwrapped

inline fun CommandMapping.remove(): CommandMapping? =
        CommandManager.removeMapping(this).unwrapped

inline val Any.ownedMappings: Set<CommandMapping>
    get() = CommandManager.getOwnedBy(this)

inline val CommandMapping.owner: PluginContainer?
    get() = CommandManager.getOwner(this).unwrapped

inline fun CommandSource.execute(arguments: String): CommandResult =
        CommandManager.process(this, arguments)

inline fun CommandSource.suggest(arguments: String, targetPosition: Location<World>?): List<String> =
        CommandManager.getSuggestions(this, arguments, targetPosition)