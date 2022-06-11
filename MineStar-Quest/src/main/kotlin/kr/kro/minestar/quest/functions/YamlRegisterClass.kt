package kr.kro.minestar.quest.functions

import kr.kro.minestar.quest.data.compensation.Compensation
import kr.kro.minestar.quest.data.compensation.ItemCompensation
import kr.kro.minestar.quest.data.contents.Content
import kr.kro.minestar.quest.data.contents.hunt.DefaultHuntContent
import kr.kro.minestar.quest.data.contents.hunt.PlayerHuntContent
import kr.kro.minestar.quest.data.contents.item.DefaultItemContent
import kr.kro.minestar.quest.data.contents.item.PlayerItemContent
import kr.kro.minestar.quest.data.quest.DefaultQuest
import kr.kro.minestar.quest.data.quest.PlayerQuest
import kr.kro.minestar.quest.data.quest.Quest
import kr.kro.minestar.quest.data.requirement.ItemRequirement
import kr.kro.minestar.quest.data.requirement.Requirement
import org.bukkit.configuration.serialization.ConfigurationSerialization

object YamlRegisterClass {
    init {
        ConfigurationSerialization.registerClass(Compensation::class.java)
        ConfigurationSerialization.registerClass(ItemCompensation::class.java)

        ConfigurationSerialization.registerClass(DefaultHuntContent::class.java)
        ConfigurationSerialization.registerClass(PlayerHuntContent::class.java)

        ConfigurationSerialization.registerClass(DefaultItemContent::class.java)
        ConfigurationSerialization.registerClass(PlayerItemContent::class.java)

        ConfigurationSerialization.registerClass(Content::class.java)

        ConfigurationSerialization.registerClass(DefaultQuest::class.java)
        ConfigurationSerialization.registerClass(PlayerQuest::class.java)
        ConfigurationSerialization.registerClass(Quest::class.java)

        ConfigurationSerialization.registerClass(Requirement::class.java)
        ConfigurationSerialization.registerClass(ItemRequirement::class.java)
    }
}