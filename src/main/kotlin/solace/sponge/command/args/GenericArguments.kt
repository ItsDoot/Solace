@file:Suppress("NOTHING_TO_INLINE")

package solace.sponge.command.args

import org.spongepowered.api.command.args.CommandElement
import org.spongepowered.api.command.args.GenericArguments

inline val CommandElement.optional: CommandElement get() = GenericArguments.optional(this)
inline val CommandElement.weakOptional: CommandElement get() = GenericArguments.optionalWeak(this)
inline val CommandElement.allOf: CommandElement get() = GenericArguments.allOf(this)
inline val CommandElement.onlyOne: CommandElement get() = GenericArguments.onlyOne(this)

inline val Array<CommandElement>.seq: CommandElement get() = GenericArguments.seq(*this)
inline val Array<CommandElement>.firstParsing: CommandElement get() = GenericArguments.firstParsing(*this)

inline fun CommandElement.requiring(permission: String): CommandElement = GenericArguments.requiringPermission(this, permission)
inline fun CommandElement.repeated(times: Int): CommandElement = GenericArguments.repeated(this, times)

inline operator fun CommandElement.not(): CommandElement = this.optional