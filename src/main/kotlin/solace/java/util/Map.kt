@file:Suppress("NOTHING_TO_INLINE")

package solace.java.util

/**
 * Creates a HashMap with starter entries, with only 1 extra object allocation.
 */
inline fun <K, V> newHashMap(init: MapBuilder<K, V>.() -> Unit): HashMap<K, V> {
    val builder = MapBuilder<K, V>()
    builder.init()
    return builder.map
}

class MapBuilder<K, V> {

    val map = HashMap<K, V>()

    inline infix fun K.at(value: V) {
        map[this] = value
    }
}