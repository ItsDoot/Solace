@file:Suppress("NOTHING_TO_INLINE")

package solace.sponge.service.permission

import org.spongepowered.api.service.permission.PermissionDescription
import org.spongepowered.api.service.permission.PermissionService
import org.spongepowered.api.service.permission.SubjectCollection
import org.spongepowered.api.service.permission.SubjectReference
import solace.java.util.unwrapped
import solace.sponge.service.service
import java.util.concurrent.CompletableFuture

inline val PermissionService: PermissionService?
    get() = org.spongepowered.api.service.permission.PermissionService::class.java.service

inline fun String.loadSubjectCollection(): CompletableFuture<SubjectCollection>? =
        PermissionService?.loadCollection(this)

inline val String.subjectCollection: SubjectCollection?
    get() = PermissionService?.getCollection(this)?.unwrapped

inline val String.isSubjectCollection: CompletableFuture<Boolean>?
    get() = PermissionService?.hasCollection(this)

inline fun String.newSubjectReference(subject: String): SubjectReference? =
        PermissionService?.newSubjectReference(this, subject)

inline fun Any.newDescriptionBuilder(): PermissionDescription.Builder? =
        PermissionService?.newDescriptionBuilder(this)

inline val String.permissionDescription: PermissionDescription?
    get() = PermissionService?.getDescription(this)?.unwrapped

inline operator fun PermissionService.invoke(identifier: String): CompletableFuture<SubjectCollection> =
        this.loadCollection(identifier)

inline operator fun PermissionService.get(identifier: String): SubjectCollection? =
        this.getCollection(identifier).unwrapped