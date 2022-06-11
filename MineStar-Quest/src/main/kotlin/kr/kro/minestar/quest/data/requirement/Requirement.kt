package kr.kro.minestar.quest.data.requirement

import org.bukkit.configuration.serialization.ConfigurationSerializable
import org.bukkit.entity.Player

interface Requirement : ConfigurationSerializable {
    fun isSatisfactory(player: Player): Boolean

    override fun serialize(): MutableMap<String, Any> = hashMapOf()
}