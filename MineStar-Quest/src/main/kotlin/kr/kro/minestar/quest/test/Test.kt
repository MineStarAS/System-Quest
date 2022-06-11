package kr.kro.minestar.quest.test

import org.bukkit.configuration.serialization.ConfigurationSerializable

class Test : ConfigurationSerializable {
    private val name: String
    private val int: Int

    override fun serialize(): Map<String, Any> {
        val result = LinkedHashMap<String, Any>()
        result["name"] = name
        result["int"] = int
        return result
    }

    override fun toString() = "$name - $int"

    constructor(name: String, int: Int) {
        this.name = name
        this.int = int
    }

    constructor(serialize: Map<String, Any>) {
        name = serialize["name"] as String
        int = serialize["int"] as Int
    }
}