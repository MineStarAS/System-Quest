package kr.kro.minestar.quest.functions

import kr.kro.minestar.utility.material.item
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.configuration.serialization.ConfigurationSerializable

class Test : ConfigurationSerializable {
    val name = "test"
    val int = 123
    val stringList = listOf("AAA", "SSS", "DDD")
    val items = listOf(
        Material.STONE.item(),
        Material.CLOCK.item(),
        Material.GRASS.item(),
    )

    override fun serialize(): Map<String, Any> {
        val result = LinkedHashMap<String, Any>()
        result["name"] = name
        result["int"] = int
        result["stringList"] = stringList
        result["items"] = items
        return result
    }

    override fun toString() = "[$name] $int : $stringList"
}