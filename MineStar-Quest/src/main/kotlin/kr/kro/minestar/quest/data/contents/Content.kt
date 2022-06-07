package kr.kro.minestar.quest.data.contents

import org.bukkit.configuration.serialization.ConfigurationSerializable

interface Content : ConfigurationSerializable {
    fun isComplete() : Boolean

    override fun serialize(): MutableMap<String, Any> = hashMapOf()
}