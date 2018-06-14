@file:Suppress("NOTHING_TO_INLINE")

package pw.dotdash.solace.sponge.service.permission

import org.spongepowered.api.service.permission.Subject
import org.spongepowered.api.service.permission.SubjectCollection
import pw.dotdash.solace.java.unwrapped
import java.util.concurrent.CompletableFuture

inline operator fun SubjectCollection.invoke(identifier: String): CompletableFuture<Subject> =
        this.loadSubject(identifier)

inline operator fun SubjectCollection.get(identifier: String): Subject? =
        this.getSubject(identifier).unwrapped

inline operator fun SubjectCollection.invoke(identifiers: Set<String>): CompletableFuture<Map<String, Subject>> =
        this.loadSubjects(identifiers)