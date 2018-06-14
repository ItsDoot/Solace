@file:Suppress("NOTHING_TO_INLINE")

package pw.dotdash.solace.sponge

import org.spongepowered.api.CatalogType
import org.spongepowered.api.GameRegistry
import org.spongepowered.api.Sponge
import org.spongepowered.api.block.BlockType
import org.spongepowered.api.entity.EntityType
import org.spongepowered.api.item.ItemType
import org.spongepowered.api.network.status.Favicon
import org.spongepowered.api.registry.CatalogRegistryModule
import org.spongepowered.api.registry.RegistryModule
import org.spongepowered.api.resourcepack.ResourcePack
import org.spongepowered.api.scoreboard.displayslot.DisplaySlot
import org.spongepowered.api.statistic.BlockStatistic
import org.spongepowered.api.statistic.EntityStatistic
import org.spongepowered.api.statistic.ItemStatistic
import org.spongepowered.api.statistic.StatisticType
import org.spongepowered.api.text.format.TextColor
import org.spongepowered.api.text.translation.Translation
import org.spongepowered.api.util.ResettableBuilder
import org.spongepowered.api.util.rotation.Rotation
import pw.dotdash.solace.java.unwrapped
import java.awt.image.BufferedImage
import java.io.InputStream
import java.net.URL
import java.nio.file.Path
import java.util.*

inline val GameRegistry: GameRegistry
    get() = Sponge.getRegistry()

inline fun <reified T : CatalogType> Class<T>.catalogType(id: String): T? =
        GameRegistry.getType(this, id).unwrapped

inline val <T : CatalogType> Class<T>.allCatalogTypes
    get() = GameRegistry.getAllOf(this)

inline fun <T : CatalogType> Class<T>.catalogTypesFor(pluginId: String) =
        GameRegistry.getAllFor(pluginId, this)

inline val <T : CatalogType> Class<T>.catalogTypesForMinecraft
    get() = GameRegistry.getAllForMinecraft(this)
inline val <T : CatalogType> Class<T>.catalogTypesForSponge
    get() = GameRegistry.getAllForSponge(this)

inline fun <T : CatalogType> Class<T>.registerCatalogModule(registryModule: CatalogRegistryModule<T>) =
        GameRegistry.registerModule(this, registryModule)

inline fun RegistryModule.register() =
        GameRegistry.registerModule(this)

inline fun <T> Class<T>.registerBuilderSupplier(noinline supplier: () -> T) =
        GameRegistry.registerBuilderSupplier(this, supplier)

inline fun <reified T : ResettableBuilder<*, in T>> Class<T>.createBuilder(): T =
        GameRegistry.createBuilder(this)

inline operator fun StatisticType.get(entityType: EntityType): EntityStatistic? =
        GameRegistry.getEntityStatistic(this, entityType).unwrapped

inline operator fun StatisticType.get(itemType: ItemType): ItemStatistic? =
        GameRegistry.getItemStatistic(this, itemType).unwrapped

inline operator fun StatisticType.get(blockType: BlockType): BlockStatistic? =
        GameRegistry.getBlockStatistic(this, blockType).unwrapped

inline val Int.rotationFromDegrees: Rotation?
    get() = GameRegistry.getRotationFromDegree(this).unwrapped

inline fun String.loadFavicon(): Favicon =
        GameRegistry.loadFavicon(this)

inline fun Path.loadFavicon(): Favicon =
        GameRegistry.loadFavicon(this)

inline fun URL.loadFavicon(): Favicon =
        GameRegistry.loadFavicon(this)

inline fun InputStream.loadFavicon(): Favicon =
        GameRegistry.loadFavicon(this)

inline fun BufferedImage.loadFavicon(): Favicon =
        GameRegistry.loadFavicon(this)

inline val String.resourcePack: ResourcePack?
    get() = GameRegistry.getResourcePackById(this).unwrapped

inline val TextColor.displaySlot: DisplaySlot?
    get() = GameRegistry.getDisplaySlotForColor(this).unwrapped

inline val String.locale: Locale
    get() = GameRegistry.getLocale(this)

inline val String.translation: Translation?
    get() = GameRegistry.getTranslationById(this).unwrapped