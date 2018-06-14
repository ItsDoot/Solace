@file:Suppress("NOTHING_TO_INLINE")

package pw.dotdash.solace.sponge.item.recipe.smelting

import org.spongepowered.api.Sponge
import org.spongepowered.api.item.inventory.ItemStackSnapshot
import org.spongepowered.api.item.recipe.smelting.SmeltingRecipe
import org.spongepowered.api.item.recipe.smelting.SmeltingRecipeRegistry
import org.spongepowered.api.item.recipe.smelting.SmeltingResult
import pw.dotdash.solace.java.unwrapped

inline val SmeltingRecipeRegistry: SmeltingRecipeRegistry
    get() = Sponge.getRegistry().smeltingRecipeRegistry

inline val ItemStackSnapshot.matchingSmeltingRecipe: SmeltingRecipe?
    get() = SmeltingRecipeRegistry.findMatchingRecipe(this).unwrapped

inline val ItemStackSnapshot.smeltingResult: SmeltingResult?
    get() = SmeltingRecipeRegistry.getResult(this).unwrapped