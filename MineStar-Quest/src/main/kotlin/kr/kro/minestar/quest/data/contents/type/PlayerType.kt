package kr.kro.minestar.quest.data.contents.type

import org.bukkit.entity.Player
import org.bukkit.event.Listener

interface PlayerType : Listener {
    val player: Player
    fun isComplete(): Boolean
}