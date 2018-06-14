@file:Suppress("NOTHING_TO_INLINE")

package pw.dotdash.solace.sponge.data

import org.spongepowered.api.Sponge
import org.spongepowered.api.data.*
import org.spongepowered.api.data.manipulator.DataManipulator
import org.spongepowered.api.data.manipulator.DataManipulatorBuilder
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator
import org.spongepowered.api.data.persistence.DataBuilder
import org.spongepowered.api.data.persistence.DataContentUpdater
import org.spongepowered.api.data.persistence.DataTranslator
import org.spongepowered.api.plugin.PluginContainer
import pw.dotdash.solace.java.unwrapped

inline val DataManager: DataManager
    get() = Sponge.getDataManager()

inline fun <T : DataSerializable> Class<T>.registerDataBuilder(builder: DataBuilder<T>): Unit =
        DataManager.registerBuilder(this, builder)

inline fun <T : DataSerializable> Class<T>.registerContentUpdater(updater: DataContentUpdater): Unit =
        DataManager.registerContentUpdater(this, updater)

inline fun <T : DataSerializable> Class<T>.getWrappedContentUpdater(fromVersion: Int, toVersion: Int): DataContentUpdater? =
        DataManager.getWrappedContentUpdater(this, fromVersion, toVersion).unwrapped

inline val <T : DataSerializable> Class<T>.dataBuilder: DataBuilder<T>?
    get() = DataManager.getBuilder(this).unwrapped

inline fun <reified T : DataSerializable> Class<T>.deserializeView(dataView: DataView): T? =
        DataManager.deserialize(this, dataView).unwrapped

inline fun <T : ImmutableDataHolder<T>, B : ImmutableDataBuilder<T, B>> Class<T>.registerDataBuilder(builder: B): Unit =
        DataManager.register(this, builder)

inline fun String.registerLegacyIds(registration: DataRegistration<*, *>) =
        DataManager.registerLegacyManipulatorIds(this, registration)

inline fun <T : ImmutableDataHolder<T>, reified B : ImmutableDataBuilder<T, B>> Class<T>.getImmutableBuilder(): B? =
        DataManager.getImmutableBuilder<T, B>(this).unwrapped

inline val <T : DataManipulator<T, I>, I : ImmutableDataManipulator<I, T>> Class<T>.manipulatorBuilder: DataManipulatorBuilder<T, I>?
    get() = DataManager.getManipulatorBuilder(this).unwrapped

inline val <T : DataManipulator<T, I>, I : ImmutableDataManipulator<I, T>> Class<I>.immutableManipulatorBuilder: DataManipulatorBuilder<T, I>?
    get() = DataManager.getImmutableManipulatorBuilder(this).unwrapped

inline fun <T> Class<T>.registerTranslator(translator: DataTranslator<T>) =
        DataManager.registerTranslator(this, translator)

inline val <T> Class<T>.translator: DataTranslator<T>?
    get() = DataManager.getTranslator(this).unwrapped

inline val PluginContainer.allDataRegistrations: MutableCollection<Class<out DataManipulator<*, *>>>
    get() = DataManager.getAllRegistrationsFor(this)

inline fun DataView.SafetyMode.createContainer(): DataContainer =
        DataManager.createContainer(this)