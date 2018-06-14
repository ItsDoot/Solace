package pw.dotdash.solace.java

import java.util.*

inline val <reified T> T?.wrapped: Optional<out T> get() = Optional.ofNullable(this)
inline operator fun <reified T> T?.not(): Optional<out T> = this.wrapped

inline val <reified T> Optional<out T>.unwrapped: T? get() = this.orElse(null)
inline operator fun <reified T> Optional<out T>.not(): T? = this.unwrapped

inline val <reified T> Optional<out T>.expected: T get() = this.get()