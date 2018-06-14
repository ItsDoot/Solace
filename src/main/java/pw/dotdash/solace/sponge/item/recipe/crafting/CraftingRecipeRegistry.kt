@file:Suppress("NOTHING_TO_INLINE")

package pw.dotdash.solace.sponge.item.recipe.crafting

import org.spongepowered.api.Sponge
import org.spongepowered.api.item.inventory.crafting.CraftingGridInventory
import org.spongepowered.api.item.recipe.crafting.CraftingRecipe
import org.spongepowered.api.item.recipe.crafting.CraftingRecipeRegistry
import org.spongepowered.api.item.recipe.crafting.CraftingResult
import org.spongepowered.api.world.World
import pw.dotdash.solace.java.unwrapped

inline val CraftingRecipeRegistry: CraftingRecipeRegistry
    get() = Sponge.getRegistry().craftingRecipeRegistry

inline fun CraftingGridInventory.findMatchingRecipe(world: World): CraftingRecipe? =
        CraftingRecipeRegistry.findMatchingRecipe(this, world).unwrapped

inline fun CraftingGridInventory.getResult(world: World): CraftingResult? =
        CraftingRecipeRegistry.getResult(this, world).unwrapped