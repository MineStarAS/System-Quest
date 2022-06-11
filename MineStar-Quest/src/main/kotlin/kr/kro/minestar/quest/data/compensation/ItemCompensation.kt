package kr.kro.minestar.quest.data.compensation

import kr.kro.minestar.utility.inventory.getEmptySlot
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class ItemCompensation : Compensation {
    val items: List<ItemStack>

    override fun compensate(player: Player): Boolean {
        val inventory = player.inventory
        val emptySlot = inventory.getEmptySlot()
        val itemKind = items.size
        if (emptySlot < itemKind) return false
        inventory.addItem(*items.toTypedArray())
        return true
    }

    override fun serialize(): MutableMap<String, Any> {
        val map = super.serialize()
        map["items"] = items
        return map
    }

    constructor(items: List<ItemStack>) {
        this.items = items
    }

    constructor(serialize: Map<String, Any>) {
        items = serialize["items"] as List<ItemStack>
    }
}