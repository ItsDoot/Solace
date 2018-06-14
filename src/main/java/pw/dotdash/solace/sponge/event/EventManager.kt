@file:Suppress("NOTHING_TO_INLINE")

package pw.dotdash.solace.sponge.event

import com.google.common.reflect.TypeToken
import org.spongepowered.api.Sponge
import org.spongepowered.api.event.Event
import org.spongepowered.api.event.EventListener
import org.spongepowered.api.event.EventManager
import org.spongepowered.api.event.Order

inline val EventManager: EventManager
    get() = Sponge.getEventManager()

inline fun Any.registerListeners(obj: Any): Unit =
        EventManager.registerListeners(this, obj)

inline fun <reified T : Event> Any.registerListener(crossinline handler: (T) -> Unit) =
        EventManager.registerListener(this, T::class.java) { event -> handler(event) }

inline fun <reified T : Event> Any.registerListener(listener: EventListener<in T>) =
        EventManager.registerListener(this, T::class.java, listener)

inline fun <reified T : Event> Any.registerListener(eventType: TypeToken<T>, listener: EventListener<in T>) =
        EventManager.registerListener(this, eventType, listener)

inline fun <reified T : Event> Any.registerListener(order: Order, listener: EventListener<in T>) =
        EventManager.registerListener(this, T::class.java, order, listener)

inline fun <reified T : Event> Any.registerListener(eventType: TypeToken<T>, order: Order, listener: EventListener<in T>) =
        EventManager.registerListener(this, eventType, order, listener)

inline fun <reified T : Event> Any.registerListener(order: Order, beforeMods: Boolean, listener: EventListener<in T>) =
        EventManager.registerListener(this, T::class.java, order, beforeMods, listener)

inline fun <reified T : Event> Any.registerListener(eventType: TypeToken<T>, order: Order, beforeMods: Boolean, listener: EventListener<in T>) =
        EventManager.registerListener(this, eventType, order, beforeMods, listener)

inline fun Any.unregisterListeners() =
        EventManager.unregisterListeners(this)

inline fun Any.unregisterPluginListeners() =
        EventManager.unregisterPluginListeners(this)

inline fun Event.post(): Boolean =
        EventManager.post(this)