@file:Suppress("NOTHING_TO_INLINE")

package solace.sponge.item.inventory

import org.spongepowered.api.item.inventory.Inventory
import org.spongepowered.api.item.inventory.InventoryProperty
import org.spongepowered.api.item.inventory.ItemStack
import org.spongepowered.api.item.inventory.Slot
import org.spongepowered.api.item.inventory.property.SlotIndex
import org.spongepowered.api.item.inventory.property.SlotPos
import org.spongepowered.api.item.inventory.query.QueryOperationTypes

inline fun <reified T : Inventory> Inventory.narrow(): T = this.query(QueryOperationTypes.INVENTORY_TYPE.of(T::class.java))

inline operator fun Inventory.get(vararg properties: InventoryProperty<*, *>): Inventory =
        this.query(*properties.map { QueryOperationTypes.INVENTORY_PROPERTY.of(it) }.toTypedArray())

inline operator fun Inventory.get(index: Int): Slot? = this[SlotIndex(index)] as? Slot

inline operator fun Inventory.get(x: Int, y: Int): Slot? = this[SlotPos(x, y)] as? Slot

inline operator fun Inventory.plusAssign(item: ItemStack) {
    this.offer(item)
}