package kr.kro.minestar.quest.functions

import kr.kro.minestar.quest.data.compensation.Compensation
import kr.kro.minestar.quest.data.compensation.ItemCompensation
import kr.kro.minestar.quest.data.contents.Content
import kr.kro.minestar.quest.data.contents.hunt.DefaultHuntContent
import kr.kro.minestar.quest.data.contents.hunt.PlayerHuntContent
import kr.kro.minestar.quest.data.contents.item.DefaultItemContent
import kr.kro.minestar.quest.data.contents.item.PlayerItemContent
import kr.kro.minestar.quest.data.quest.DefaultQuest
import kr.kro.minestar.quest.data.player.PlayerProgressQuest
import kr.kro.minestar.quest.data.quest.Quest
import kr.kro.minestar.quest.data.requirement.ItemRequirement
import kr.kro.minestar.quest.data.requirement.Requirement
import org.bukkit.configuration.serialization.ConfigurationSerializable
import org.bukkit.configuration.serialization.ConfigurationSerialization
import kotlin.reflect.KClass

object YamlRegisterClass {

    fun registerClass(clazz: KClass<out ConfigurationSerializable>) = ConfigurationSerialization.registerClass(clazz.java)
    fun registerClass(clazz: Class<out ConfigurationSerializable>) = ConfigurationSerialization.registerClass(clazz)

    init {
        //Requirement
        registerClass(Requirement::class)

        registerClass(ItemRequirement::class)

        //Compensation
        registerClass(Compensation::class)

        registerClass(ItemCompensation::class)

        //Content
        registerClass(Content::class)

        registerClass(DefaultHuntContent::class)
        registerClass(PlayerHuntContent::class)
        registerClass(DefaultItemContent::class)
        registerClass(PlayerItemContent::class)

        //Quest
        registerClass(Quest::class)

        registerClass(DefaultQuest::class)
        registerClass(PlayerProgressQuest::class)
    }

}