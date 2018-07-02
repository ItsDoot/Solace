@file:Suppress("NOTHING_TO_INLINE")

package solace.sponge.command.args

import org.spongepowered.api.command.args.CommandElement
import org.spongepowered.api.command.args.CommandFlags
import org.spongepowered.api.command.args.GenericArguments

inline fun CommandFlags.Builder.build(): CommandElement = this.buildWith(GenericArguments.none())