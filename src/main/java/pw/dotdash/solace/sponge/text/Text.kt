@file:Suppress("NOTHING_TO_INLINE")

package pw.dotdash.solace.sponge.text

import org.spongepowered.api.text.Text
import org.spongepowered.api.text.action.ClickAction
import org.spongepowered.api.text.action.HoverAction
import org.spongepowered.api.text.action.ShiftClickAction
import org.spongepowered.api.text.channel.MessageChannel
import org.spongepowered.api.text.chat.ChatType
import org.spongepowered.api.text.format.TextColor
import org.spongepowered.api.text.format.TextColors
import org.spongepowered.api.text.format.TextStyle
import org.spongepowered.api.text.format.TextStyles
import org.spongepowered.api.text.serializer.TextSerializer
import org.spongepowered.api.text.serializer.TextSerializers
import pw.dotdash.solace.sponge.Server

inline fun Text.color(color: TextColor): Text = Text.builder().append(this).color(color).build()

inline val Text.aqua: Text get() = this.color(TextColors.AQUA)
inline val Text.black: Text get() = this.color(TextColors.BLACK)
inline val Text.blue: Text get() = this.color(TextColors.BLUE)
inline val Text.darkAqua: Text get() = this.color(TextColors.DARK_AQUA)
inline val Text.darkBlue: Text get() = this.color(TextColors.DARK_BLUE)
inline val Text.darkGray: Text get() = this.color(TextColors.DARK_GRAY)
inline val Text.darkGreen: Text get() = this.color(TextColors.DARK_GREEN)
inline val Text.darkPurple: Text get() = this.color(TextColors.DARK_PURPLE)
inline val Text.darkRed: Text get() = this.color(TextColors.DARK_RED)
inline val Text.gold: Text get() = this.color(TextColors.GOLD)
inline val Text.gray: Text get() = this.color(TextColors.GRAY)
inline val Text.green: Text get() = this.color(TextColors.GREEN)
inline val Text.lightPurple: Text get() = this.color(TextColors.LIGHT_PURPLE)
inline val Text.red: Text get() = this.color(TextColors.RED)
inline val Text.white: Text get() = this.color(TextColors.WHITE)
inline val Text.yellow: Text get() = this.color(TextColors.YELLOW)

inline fun Text.style(style: TextStyle): Text = Text.builder().append(this).style(style).build()

inline val Text.bold: Text get() = this.style(TextStyles.BOLD)
inline val Text.italic: Text get() = this.style(TextStyles.ITALIC)
inline val Text.obfuscated: Text get() = this.style(TextStyles.OBFUSCATED)
inline val Text.reset: Text get() = this.style(TextStyles.RESET)
inline val Text.strikethrough: Text get() = this.style(TextStyles.STRIKETHROUGH)
inline val Text.underline: Text get() = this.style(TextStyles.UNDERLINE)

inline fun <T : ClickAction<*>> Text.click(action: T): Text = Text.builder().append(this).onClick(action).build()
inline fun <T : ShiftClickAction<*>> Text.shiftClick(action: T): Text = Text.builder().append(this).onShiftClick(action).build()
inline fun <T : HoverAction<*>> Text.Hover(action: T): Text = Text.builder().append(this).onHover(action).build()

inline val String.text: Text get() = Text.of(this)

inline fun String.color(color: TextColor): Text = Text.builder(this).color(color).build()

inline val String.aqua: Text get() = this.color(TextColors.AQUA)
inline val String.black: Text get() = this.color(TextColors.BLACK)
inline val String.blue: Text get() = this.color(TextColors.BLUE)
inline val String.darkAqua: Text get() = this.color(TextColors.DARK_AQUA)
inline val String.darkBlue: Text get() = this.color(TextColors.DARK_BLUE)
inline val String.darkGray: Text get() = this.color(TextColors.DARK_GRAY)
inline val String.darkGreen: Text get() = this.color(TextColors.DARK_GREEN)
inline val String.darkPurple: Text get() = this.color(TextColors.DARK_PURPLE)
inline val String.darkRed: Text get() = this.color(TextColors.DARK_RED)
inline val String.gold: Text get() = this.color(TextColors.GOLD)
inline val String.gray: Text get() = this.color(TextColors.GRAY)
inline val String.green: Text get() = this.color(TextColors.GREEN)
inline val String.lightPurple: Text get() = this.color(TextColors.LIGHT_PURPLE)
inline val String.red: Text get() = this.color(TextColors.RED)
inline val String.white: Text get() = this.color(TextColors.WHITE)
inline val String.yellow: Text get() = this.color(TextColors.YELLOW)

inline fun String.style(style: TextStyle): Text = Text.builder(this).style(style).build()

inline val String.bold: Text get() = this.style(TextStyles.BOLD)
inline val String.italic: Text get() = this.style(TextStyles.ITALIC)
inline val String.obfuscated: Text get() = this.style(TextStyles.OBFUSCATED)
inline val String.reset: Text get() = this.style(TextStyles.RESET)
inline val String.strikethrough: Text get() = this.style(TextStyles.STRIKETHROUGH)
inline val String.underline: Text get() = this.style(TextStyles.UNDERLINE)

inline fun <T : ClickAction<*>> String.click(action: T): Text = Text.builder(this).onClick(action).build()
inline fun <T : ShiftClickAction<*>> String.shiftClick(action: T): Text = Text.builder(this).onShiftClick(action).build()
inline fun <T : HoverAction<*>> String.Hover(action: T): Text = Text.builder(this).onHover(action).build()

inline fun Text.serialize(serializer: TextSerializer = TextSerializers.FORMATTING_CODE): String =
        serializer.serialize(this)

inline fun String.deserialize(serializer: TextSerializer = TextSerializers.FORMATTING_CODE): Text =
        serializer.deserialize(this)

inline fun Text.broadcast() = Server.broadcastChannel.send(this)
inline fun Text.broadcast(type: ChatType) = Server.broadcastChannel.send(this, type)

inline infix fun Text.sendTo(channel: MessageChannel) = channel.send(this)