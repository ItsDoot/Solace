@file:Suppress("NOTHING_TO_INLINE")

package pw.dotdash.solace.sponge.command

import org.spongepowered.api.command.CommandResult
import org.spongepowered.api.command.CommandSource
import org.spongepowered.api.command.args.CommandContext
import org.spongepowered.api.command.spec.CommandExecutor
import org.spongepowered.api.command.spec.CommandSpec

inline fun CommandSpec(building: CommandSpec.Builder.() -> Unit): CommandSpec =
        CommandSpec.builder().apply(building).build()

inline fun CommandSpec.Builder.executer(noinline executor: (CommandSource, CommandContext) -> CommandResult): CommandSpec.Builder =
        this.executor(CommandExecutor(executor))