package solace.java.util

import java.util.*

inline val <reified T> T?.wrapped: Optional<out T> get() = Optional.ofNullable(this)
inline operator fun <reified T> T?.not(): Optional<out T> = Optional.ofNullable(this)

inline val <reified T> T?.expected: T
    get() = this ?: throw IllegalStateException("Expected ${T::class}, but was null.")

inline val <reified T> Optional<out T>.unwrapped: T? get() = this.orElse(null)
inline operator fun <reified T> Optional<out T>.not(): T? = this.orElse(null)

inline val <reified T> Optional<out T>.expected: T
    get() = this.unwrapped ?: throw IllegalStateException("Expected ${T::class}, but was null.")

inline fun <reified T : Any> Iterable<Optional<T>>.filterOptional(): Iterable<T> =
        this.mapNotNull { it.unwrapped }

inline fun <reified T : Any, reified R : Any> Iterable<Optional<T>>.mapOptional(noinline fn: (T) -> R): Iterable<Optional<R>> =
        this.map { it.map(fn) }

inline fun <reified T : Any, reified R : Any> Iterable<Optional<T>>.filterMapOptional(fn: (T) -> R): Iterable<R> =
        this.mapNotNull { it.unwrapped?.let(fn) }