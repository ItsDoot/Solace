package solace.sponge.scheduler

import org.spongepowered.api.Sponge
import org.spongepowered.api.scheduler.Scheduler
import org.spongepowered.api.scheduler.SpongeExecutorService
import org.spongepowered.api.scheduler.Task
import solace.java.util.unwrapped
import java.util.*

inline val Scheduler: Scheduler
    get() = Sponge.getScheduler()

inline val UUID.task: Task?
    get() = Scheduler.getTaskById(this).unwrapped

inline val String.tasksByPattern: Set<Task>
    get() = Scheduler.getTasksByName(this)

inline val Any.scheduledTasks: Set<Task>
    get() = Scheduler.getScheduledTasks(this)

inline val Any.syncExecutor: SpongeExecutorService
    get() = Scheduler.createSyncExecutor(this)

inline val Any.asyncExecutor: SpongeExecutorService
    get() = Scheduler.createAsyncExecutor(this)