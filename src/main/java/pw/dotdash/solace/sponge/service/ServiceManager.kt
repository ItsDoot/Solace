package pw.dotdash.solace.sponge.service

import org.spongepowered.api.Sponge
import org.spongepowered.api.service.ProviderRegistration
import org.spongepowered.api.service.ServiceManager
import pw.dotdash.solace.java.unwrapped

inline val ServiceManager: ServiceManager
    get() = Sponge.getServiceManager()

inline fun <reified T> Any.setServiceProvider(provider: T) =
        ServiceManager.setProvider(this, T::class.java, provider)

inline val <reified T> Class<T>.service: T?
    get() = ServiceManager.provide(this).unwrapped

inline val <T> Class<T>.serviceRegistration: ProviderRegistration<T>?
    get() = ServiceManager.getRegistration(this).unwrapped

inline val Class<*>.registeredService: Boolean
    get() = ServiceManager.isRegistered(this)

inline val <reified T> Class<T>.uncheckedService: T
    get() = ServiceManager.provideUnchecked(this)