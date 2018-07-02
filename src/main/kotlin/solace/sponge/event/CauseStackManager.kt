@file:Suppress("NOTHING_TO_INLINE")

package solace.sponge.event

import org.omg.CORBA.Object
import org.spongepowered.api.Sponge
import org.spongepowered.api.event.CauseStackManager
import org.spongepowered.api.event.cause.EventContextKey
import solace.java.util.unwrapped

inline val CauseStackManager: CauseStackManager
    get() = Sponge.getCauseStackManager()

inline fun Object.pushCause(): CauseStackManager =
        CauseStackManager.pushCause(this)

inline fun CauseStackManager.StackFrame.pop() =
        CauseStackManager.popCauseFrame(this)

inline fun <T> EventContextKey<T>.add(value: T) =
        CauseStackManager.addContext(this, value)

inline val <reified T> EventContextKey<T>.context: T?
    get() = CauseStackManager.getContext(this).unwrapped

inline val <T> EventContextKey<T>.required: T
    get() = CauseStackManager.requireContext(this)

inline fun <reified T> EventContextKey<T>.remove(): T? =
        CauseStackManager.removeContext(this).unwrapped

inline operator fun CauseStackManager.plusAssign(obj: Any): Unit {
    this.pushCause(obj)
}

inline operator fun CauseStackManager.invoke(): Any =
        this.popCause()

inline operator fun CauseStackManager.invoke(n: Int): Unit =
        this.popCauses(n)