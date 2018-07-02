@file:Suppress("NOTHING_TO_INLINE")

package solace.sponge.entity.living.player

import org.spongepowered.api.data.type.HandTypes
import org.spongepowered.api.entity.living.player.Player
import org.spongepowered.api.entity.living.player.tab.TabListEntry
import org.spongepowered.api.item.inventory.ItemStack
import org.spongepowered.api.item.inventory.entity.Hotbar
import org.spongepowered.api.item.inventory.entity.MainPlayerInventory
import org.spongepowered.api.item.inventory.equipment.EquipmentInventory
import solace.java.util.unwrapped
import solace.sponge.item.inventory.narrow

inline val Player.mainInventory get() = this.inventory.narrow<MainPlayerInventory>()
inline val Player.hotbar get() = this.inventory.narrow<Hotbar>()
inline val Player.equipmentInventory get() = this.inventory.narrow<EquipmentInventory>()

inline infix fun Player.give(item: ItemStack) {
    if (!this.getItemInHand(HandTypes.MAIN_HAND).isPresent) {
        this.setItemInHand(HandTypes.MAIN_HAND, item)
    } else {
        this.mainInventory.offer(item)
    }
}

inline val Player.tabListEntry: TabListEntry? get() = this.tabList.getEntry(this.uniqueId).unwrapped

inline val Player.prefix: String? get() = this.getOption("prefix").unwrapped
inline val Player.suffix: String? get() = this.getOption("suffix").unwrapped