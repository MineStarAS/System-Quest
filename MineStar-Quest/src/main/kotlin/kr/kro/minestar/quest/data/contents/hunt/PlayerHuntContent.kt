package kr.kro.minestar.quest.data.contents.hunt

import kr.kro.minestar.quest.Main.Companion.pl
import kr.kro.minestar.quest.data.contents.type.PlayerType
import kr.kro.minestar.utility.event.enable
import kr.kro.minestar.utility.string.unColor
import org.bukkit.entity.Entity
import org.bukkit.entity.Player

class PlayerHuntContent(
    override val player: Player, override val entityName: String,
    override val amount: Int, var huntedAmount: Int
) : DefaultHuntContent(entityName, amount), PlayerType {

    init {
        enable(pl)
    }

    fun addHuntedAmount(entity: Entity): Boolean {
        if (isComplete()) return false
        val customName = entity.customName?.unColor() ?: return false
        if (entityName.unColor() != entity.customName?.unColor()) return false
        huntedAmount++
        return true
    }

    override fun isComplete() = huntedAmount <= amount

    override fun serialize(): MutableMap<String, Any> {
        val map = super.serialize()
        map["player"] = player
        map["huntedAmount"] = huntedAmount
        return map
    }
}