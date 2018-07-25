package solace.sponge.item.inventory

import org.spongepowered.api.data.key.Keys
import org.spongepowered.api.entity.EntityTypes
import org.spongepowered.api.item.inventory.ItemStack
import org.spongepowered.api.world.Location
import org.spongepowered.api.world.World

inline fun ItemStack(building: ItemStack.Builder.() -> Unit): ItemStack =
        ItemStack.builder().apply(building).build()

inline fun ItemStack.drop(location: Location<World>) {
    val item = location.createEntity(EntityTypes.ITEM)
    item.offer(Keys.REPRESENTED_ITEM, this.createSnapshot())

    location.spawnEntity(item)
}