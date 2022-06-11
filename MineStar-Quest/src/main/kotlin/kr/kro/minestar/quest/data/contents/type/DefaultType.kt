package kr.kro.minestar.quest.data.contents.type

import org.bukkit.entity.Player

interface DefaultType {
    fun toPlayerType(player: Player) : PlayerType
}