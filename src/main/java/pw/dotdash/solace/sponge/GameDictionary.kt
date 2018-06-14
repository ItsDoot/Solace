@file:Suppress("NOTHING_TO_INLINE")

package pw.dotdash.solace.sponge

import org.spongepowered.api.GameDictionary
import org.spongepowered.api.Sponge
import pw.dotdash.solace.java.unwrapped

inline val GameDictionary: GameDictionary?
    get() = Sponge.getGame().gameDictionary.unwrapped

inline fun String.registerDictionaryEntry(entry: GameDictionary.Entry) {
    GameDictionary?.register(this, entry)
}

inline val String.dictionaryEntries: Set<GameDictionary.Entry>?
    get() = GameDictionary?.get(this)