package kr.kro.minestar.quest.data.compensation

import org.bukkit.configuration.serialization.ConfigurationSerializable
import org.bukkit.entity.Player

interface Compensation : ConfigurationSerializable {

    fun compensate(player: Player): Boolean

    override fun serialize(): MutableMap<String, Any> = hashMapOf()
}