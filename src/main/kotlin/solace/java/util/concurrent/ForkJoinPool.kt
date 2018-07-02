package solace.java.util.concurrent

import java.util.concurrent.ForkJoinPool

inline val ForkJoinExecutor: ForkJoinPool get() = ForkJoinPool.commonPool()