package pw.dotdash.solace.sponge.item.inventory

import org.spongepowered.api.item.inventory.ItemStack

inline fun ItemStack(building: ItemStack.Builder.() -> Unit): ItemStack =
        ItemStack.builder().apply(building).build()