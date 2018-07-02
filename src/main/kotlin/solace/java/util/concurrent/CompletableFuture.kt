@file:Suppress("NOTHING_TO_INLINE")

package solace.java.util.concurrent

import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Supplier

inline fun <T, U> CompletableFuture<T>.map(noinline fn: (T) -> U): CompletableFuture<U> =
        this.thenApply(fn)

inline fun <T, U> CompletableFuture<T>.mapAsync(executor: Executor = ForkJoinExecutor, crossinline fn: (T) -> U): CompletableFuture<U> =
        this.thenApplyAsync(java.util.function.Function { fn(it) }, executor)

inline fun <T, U> CompletableFuture<T>.flatMap(noinline fn: (T) -> CompletableFuture<U>): CompletableFuture<U> =
        this.thenCompose(fn)

inline fun <T, U> CompletableFuture<T>.flatMapAsync(executor: Executor = ForkJoinExecutor, crossinline fn: (T) -> CompletableFuture<U>): CompletableFuture<U> =
        this.thenComposeAsync(java.util.function.Function { fn(it) }, executor)

inline fun <T> CompletableFuture<T>.filter(crossinline predicate: (T) -> Boolean): CompletableFuture<T> =
        this.map { if (predicate(it)) it else throw NoSuchElementException("CompletableFuture.filter() was not satisfied") }

inline fun <T> CompletableFuture<T>.filterAsync(executor: Executor = ForkJoinExecutor, crossinline predicate: (T) -> Boolean): CompletableFuture<T> =
        this.mapAsync(executor) { if (predicate(it)) it else throw NoSuchElementException("CompletableFuture.filter() was not satisfied") }

inline fun <T, U> CompletableFuture<T>.and(other: CompletableFuture<U>): CompletableFuture<Pair<T, U>> =
        this.thenCombine(other) { t, u -> t to u }

inline fun <T, U> CompletableFuture<T>.andAsync(other: CompletableFuture<U>, executor: Executor = ForkJoinExecutor): CompletableFuture<Pair<T, U>> =
        this.thenCombineAsync(other, java.util.function.BiFunction { t, u -> t to u }, executor)

inline fun <T, U, R> CompletableFuture<T>.zip(other: CompletableFuture<U>, crossinline fn: (T, U) -> R): CompletableFuture<R> =
        this.thenCombine(other) { t, u -> fn(t, u) }

inline fun <T, U, R> CompletableFuture<T>.zipAsync(other: CompletableFuture<U>, executor: Executor = ForkJoinExecutor, crossinline fn: (T, U) -> R): CompletableFuture<R> =
        this.thenCombineAsync(other, java.util.function.BiFunction { t, u -> fn(t, u) }, executor)

inline fun <T> CompletableFuture<CompletableFuture<T>>.flatten(): CompletableFuture<T> =
        this.flatMap { it }

inline fun <T> CompletableFuture<CompletableFuture<T>>.flattenAsync(executor: Executor = ForkJoinExecutor): CompletableFuture<T> =
        this.flatMapAsync(executor) { it }

inline fun <T> CompletableFuture<T>.onFulfilled(crossinline onFulfilled: (T) -> Unit): CompletableFuture<T> =
        this.whenComplete { t, _ ->
            onFulfilled(t)
        }

inline fun <T> CompletableFuture<T>.onFulfilledAsync(executor: Executor = ForkJoinExecutor, crossinline onFulfilled: (T) -> Unit): CompletableFuture<T> =
        this.whenCompleteAsync(java.util.function.BiConsumer { t, _ ->
            onFulfilled(t)
        }, executor)

inline fun <T> CompletableFuture<T>.onRejected(crossinline onRejected: (Throwable) -> Unit): CompletableFuture<T> =
        this.whenComplete { _, throwable: Throwable? ->
            throwable?.let { onRejected(it.cause ?: it) }
        }

inline fun <T> CompletableFuture<T>.onRejectedAsync(executor: Executor = ForkJoinExecutor, crossinline onRejected: (Throwable) -> Unit): CompletableFuture<T> =
        this.whenCompleteAsync(java.util.function.BiConsumer { _, throwable: Throwable? ->
            throwable?.let { onRejected(it.cause ?: it) }
        }, executor)

inline fun <T> CompletableFuture<T>.onComplete(crossinline onFulfilled: (T) -> Unit, crossinline onRejected: (Throwable) -> Unit): CompletableFuture<T> =
        this.whenComplete { t, throwable: Throwable? ->
            if (throwable == null) {
                onFulfilled(t)
            } else {
                onRejected(throwable.cause ?: throwable)
            }
        }

inline fun <T> CompletableFuture<T>.onCompleteAsync(executor: Executor = ForkJoinExecutor, crossinline onFulfilled: (T) -> Unit, crossinline onRejected: (Throwable) -> Unit): CompletableFuture<T> =
        this.whenCompleteAsync(java.util.function.BiConsumer { t, throwable: Throwable? ->
            if (throwable == null) {
                onFulfilled(t)
            } else {
                onRejected(throwable.cause ?: throwable)
            }
        }, executor)

inline fun <T> T.toCompletableFuture(): CompletableFuture<T> =
        CompletableFuture.completedFuture(this)

inline fun <T> (() -> T).toCompletableFuture(): CompletableFuture<T> =
        CompletableFuture.supplyAsync(this)

inline fun <T> (() -> T).toCompletableFuture(executor: Executor = ForkJoinExecutor): CompletableFuture<T> =
        CompletableFuture.supplyAsync(Supplier(this), executor)

inline fun Array<CompletableFuture<*>>.allOf(): CompletableFuture<Void> = CompletableFuture.allOf(*this)

inline fun Collection<CompletableFuture<*>>.allOf(): CompletableFuture<Void> = CompletableFuture.allOf(*this.toTypedArray())

inline fun Array<CompletableFuture<*>>.anyOf(): CompletableFuture<Any> = CompletableFuture.anyOf(*this)

inline fun Collection<CompletableFuture<*>>.anyOf(): CompletableFuture<Any> = CompletableFuture.anyOf(*this.toTypedArray())

inline fun <T, R> Iterable<CompletableFuture<T>>.foldAsync(initial: R, executor: Executor = ForkJoinExecutor, noinline op: (R, T) -> R): CompletableFuture<R> =
        this.iterator().foldAsync(initial, executor, op)

fun <T, R> Iterator<CompletableFuture<T>>.foldAsync(initial: R, executor: Executor = ForkJoinExecutor, op: (R, T) -> R): CompletableFuture<R> =
        if (!this.hasNext())
            initial.toCompletableFuture()
        else
            this.next().flatMapAsync(executor) { foldAsync(op(initial, it), executor, op) }

inline fun <T> Iterable<CompletableFuture<T>>.reduceAsync(executor: Executor = ForkJoinExecutor, noinline op: (T, T) -> T): CompletableFuture<out T?> =
        this.iterator().reduceAsync(executor, op)

inline fun <T> Iterator<CompletableFuture<T>>.reduceAsync(executor: Executor = ForkJoinExecutor, noinline op: (T, T) -> T): CompletableFuture<out T?> =
        if (!this.hasNext())
            CompletableFuture.supplyAsync { null }
        else
            this.next().flatMapAsync { foldAsync(it, executor, op) }

inline fun <T, U> Iterable<CompletableFuture<T>>.transformAsync(executor: Executor = ForkJoinExecutor, crossinline fn: (T) -> U): CompletableFuture<List<U>> =
        this.fold(mutableListOf<U>().toCompletableFuture()) { list: CompletableFuture<MutableList<U>>, element: CompletableFuture<T> ->
            list.zipAsync(element, executor) { result: MutableList<U>, next: T -> result.add(fn(next)); result }
        }.mapAsync(executor) { it.toList() }