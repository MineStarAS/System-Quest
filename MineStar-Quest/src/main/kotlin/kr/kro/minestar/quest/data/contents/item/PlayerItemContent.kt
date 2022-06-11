package kr.kro.minestar.quest.data.contents.item

import kr.kro.minestar.quest.Main
import kr.kro.minestar.quest.data.contents.type.PlayerType
import kr.kro.minestar.utility.event.enable
import kr.kro.minestar.utility.inventory.howManyHasSameItem
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class PlayerItemContent(override val player: Player, override val item: ItemStack) : DefaultItemContent(item), PlayerType {

    init {
        enable(Main.pl)
    }

    override fun isComplete() = player.inventory.howManyHasSameItem(item) >= item.amount

    override fun serialize(): MutableMap<String, Any> {
        val map = super.serialize()
        map["player"] = player
        map["item"] = item
        return map
    }
}