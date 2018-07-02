@file:Suppress("NOTHING_TO_INLINE")

package solace.sponge.data.value

import org.spongepowered.api.Sponge
import org.spongepowered.api.data.key.Key
import org.spongepowered.api.data.value.ValueFactory
import org.spongepowered.api.data.value.mutable.*

inline val ValueFactory: ValueFactory
    get() = Sponge.getRegistry().valueFactory

inline fun <E> Key<MutableBoundedValue<E>>.MutableBoundedValue(building: ValueFactory.BoundedValueBuilder<E>.() -> Unit) =
        ValueFactory.createBoundedValueBuilder(this).apply(building).build()

inline fun <E> Key<Value<E>>.createValue(element: E): Value<E> =
        ValueFactory.createValue(this, element)

inline fun <E> Key<Value<E>>.createValue(element: E, defaultValue: E): Value<E> =
        ValueFactory.createValue(this, element, defaultValue)

inline fun <E> Key<ListValue<E>>.createListValue(elements: List<E>): ListValue<E> =
        ValueFactory.createListValue(this, elements)

inline fun <E> Key<ListValue<E>>.createListValue(elements: List<E>, defaults: List<E>): ListValue<E> =
        ValueFactory.createListValue(this, elements, defaults)

inline fun <E> Key<SetValue<E>>.createSetValue(elements: Set<E>): SetValue<E> =
        ValueFactory.createSetValue(this, elements)

inline fun <E> Key<SetValue<E>>.createSetValue(elements: Set<E>, defaults: Set<E>): SetValue<E> =
        ValueFactory.createSetValue(this, elements, defaults)

inline fun <K, V> Key<MapValue<K, V>>.createMapValue(map: Map<K, V>): MapValue<K, V> =
        ValueFactory.createMapValue(this, map)

inline fun <K, V> Key<MapValue<K, V>>.createMapValue(map: Map<K, V>, defaults: Map<K, V>): MapValue<K, V> =
        ValueFactory.createMapValue(this, map, defaults)

inline fun <E> Key<MutableBoundedValue<E>>.createBoundedValueBuilder(): ValueFactory.BoundedValueBuilder<E> =
        ValueFactory.createBoundedValueBuilder(this)

inline fun <E> Key<OptionalValue<E>>.createOptionalValue(element: E?): OptionalValue<E> =
        ValueFactory.createOptionalValue(this, element)

inline fun <E> Key<OptionalValue<E>>.createOptionalValue(element: E?, defaultElement: E): OptionalValue<E> =
        ValueFactory.createOptionalValue(this, element, defaultElement)