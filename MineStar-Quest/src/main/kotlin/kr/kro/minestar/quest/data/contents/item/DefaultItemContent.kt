package kr.kro.minestar.quest.data.contents.item

import kr.kro.minestar.quest.data.contents.Content
import org.bukkit.inventory.ItemStack

open class DefaultItemContent(open val item: ItemStack) : Content {

    override fun isComplete() =  false //player.inventory.howManyHasSameItem(item) >= item.amount
    override fun serialize(): MutableMap<String, Any> {
        val map = super.serialize()
        map["item"] = item
        return map
    }
}