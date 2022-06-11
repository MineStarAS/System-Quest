package kr.kro.minestar.quest.functions

import kr.kro.minestar.quest.data.contents.hunt.DefaultHuntContent
import kr.kro.minestar.utility.material.item
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.configuration.serialization.ConfigurationSerializable

class Test : ConfigurationSerializable {
    val name = "test"
    val c = DefaultHuntContent("test", 123)

    override fun serialize(): Map<String, Any> {
        val result = LinkedHashMap<String, Any>()
        result["name"] = name
        result["c"] = c
        return result
    }

    override fun toString() = "$name - ${c.entityName} : ${c.amount}"
}