package kr.kro.minestar.quest.data.contents.hunt

import kr.kro.minestar.quest.data.contents.Content
import kr.kro.minestar.quest.data.contents.type.DefaultType
import org.bukkit.entity.Player
import org.bukkit.util.NumberConversions

open class DefaultHuntContent(open val entityName: String, open val amount: Int) : DefaultType, Content {

    fun deserialize(args: Map<String?, Any?>): DefaultHuntContent {
        val entityName = args["entityName"] as String
        val amount = NumberConversions.toInt(args["amount"])
        return DefaultHuntContent(entityName, amount)
    }

    override fun serialize(): MutableMap<String, Any> {
        val map = super.serialize()
        map["entityName"] = entityName
        map["amount"] = amount
        return map
    }

    override fun toPlayerType(player: Player) = PlayerHuntContent(player, entityName, amount, 0)
}