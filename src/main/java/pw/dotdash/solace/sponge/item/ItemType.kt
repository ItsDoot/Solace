@file:Suppress("NOTHING_TO_INLINE")

package pw.dotdash.solace.sponge.item

import org.spongepowered.api.item.ItemType
import org.spongepowered.api.item.inventory.ItemStack

inline fun ItemType.stack(quantity: Int): ItemStack =
        ItemStack.of(this, quantity)