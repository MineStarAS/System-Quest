package kr.kro.minestar.quest.data.requirement

import kr.kro.minestar.utility.inventory.hasSameItem
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class ItemRequirement(val item: ItemStack) : Requirement {
    override fun isSatisfactory(player: Player): Boolean {
        return player.inventory.hasSameItem(item)
    }

    override fun serialize(): MutableMap<String, Any> {
        val map = super.serialize()
        map["item"] = item
        return map
    }
}