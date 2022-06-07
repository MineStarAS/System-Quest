package kr.kro.minestar.quest.data.compensation

import kr.kro.minestar.utility.inventory.getEmptySlot
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class ItemCompensation(val items: List<ItemStack>) : Compensation {
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
        map
        return map
    }

    fun test(yaml: YamlConfiguration) {

    }
}