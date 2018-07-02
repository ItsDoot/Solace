@file:Suppress("NOTHING_TO_INLINE")

package solace.sponge.text

import org.spongepowered.api.text.Text
import org.spongepowered.api.text.TextTemplate

inline operator fun TextTemplate.invoke(vararg pairs: Pair<String, Any>): Text =
        apply(pairs.toMap()).build()

inline operator fun List<TextTemplate>.invoke(vararg pairs: Pair<String, Any>): List<Text> =
        map { it(*pairs) }