package kr.kro.minestar.quest.data.player

import kr.kro.minestar.quest.data.quest.Quest
import org.bukkit.configuration.serialization.ConfigurationSerializable
import org.bukkit.entity.Player

class PlayerProgressQuest : ConfigurationSerializable {
    companion object {
        private val map = hashMapOf<Player, HashSet<PlayerProgressQuest>>()
        fun addProgressQuest (player: Player, quest: PlayerProgressQuest) {
            if (!map.containsKey(player)) map[player] = hashSetOf()
            val set = map[player]!!
            set.add(quest)
        }

        fun removeProgressQuest (player: Player, quest: PlayerProgressQuest) {
            if (!map.containsKey(player)) return
            val list = map[player]!!
        }
    }
    val player: Player
    val quest: Quest

    constructor(player: Player, quest: Quest) {
        this.player = player
        this.quest = quest
    }

    constructor(serialize: Map<String, Any>) {
        player = serialize["player"] as Player
        quest = serialize["quest"] as Quest
    }

    override fun serialize(): MutableMap<String, Any> {
        val map = hashMapOf<String, Any>()
        map["player"] = player
        map["player"] = quest
        return map
    }
}