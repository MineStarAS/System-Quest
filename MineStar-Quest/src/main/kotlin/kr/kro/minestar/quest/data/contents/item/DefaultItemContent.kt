package kr.kro.minestar.quest.data.contents.item

import kr.kro.minestar.quest.data.contents.Content
import kr.kro.minestar.quest.data.contents.hunt.PlayerHuntContent
import kr.kro.minestar.quest.data.contents.type.DefaultType
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

open class DefaultItemContent(open val item: ItemStack) : DefaultType, Content {

    override fun serialize(): MutableMap<String, Any> {
        val map = super.serialize()
        map["item"] = item
        return map
    }

    override fun toPlayerType(player: Player) = PlayerItemContent(player, item)
}