package kr.kro.minestar.quest.data.compensation

import kr.kro.minestar.utility.inventory.getEmptySlot
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class ItemCompensation : Compensation {
    val item: ItemStack

    override fun compensate(player: Player): Boolean {
        val inventory = player.inventory
        val emptySlot = inventory.getEmptySlot()
        inventory.addItem(item)
        return true
    }

    override fun serialize(): MutableMap<String, Any> {
        val map = super.serialize()
        map["item"] = item
        return map
    }

    constructor(item: ItemStack) {
        this.item = item
    }

    constructor(serialize: Map<String, Any>) {
        item = serialize["item"] as ItemStack
    }
}