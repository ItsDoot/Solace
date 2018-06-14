@file:Suppress("NOTHING_TO_INLINE")

package pw.dotdash.solace.sponge.service.permission

import org.spongepowered.api.service.context.Context
import org.spongepowered.api.service.permission.Subject
import org.spongepowered.api.service.permission.SubjectReference
import org.spongepowered.api.util.Tristate
import pw.dotdash.solace.java.unwrapped

inline operator fun Subject.contains(permission: String): Boolean =
        this.hasPermission(permission)

inline operator fun Subject.get(permission: String): Tristate =
        this.getPermissionValue(this.activeContexts, permission)

inline operator fun Subject.get(contexts: Set<Context>, permission: String): Tristate =
        this.getPermissionValue(contexts, permission)

inline operator fun SubjectReference.contains(subject: Subject) =
        subject.isChildOf(this)

inline operator fun Subject.invoke(key: String): String? =
        this.getOption(key).unwrapped