package kr.kro.minestar.quest.data.quest

import kr.kro.minestar.quest.Main.Companion.pl
import kr.kro.minestar.quest.data.compensation.Compensation
import kr.kro.minestar.quest.data.contents.Content
import kr.kro.minestar.quest.data.contents.hunt.DefaultHuntContent
import kr.kro.minestar.quest.data.requirement.Requirement
import kr.kro.minestar.quest.functions.UtilityClass
import org.bukkit.Location
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.inventory.ItemStack
import java.io.File

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class DefaultQuest : Quest() {

    companion object {
        private val questSet = hashSetOf<Quest>()

        private val questFolder = File(pl.dataFolder, "quest")

        fun loadQuests() {
            questSet.clear()
            fun loadQuest(folder: File) {
                val fileList = folder.listFiles().toList()

                for (file in fileList) {
                    if (file.isDirectory) loadQuest(file)
                    if (!file.name.contains(".yml")) continue

                    val yaml = YamlConfiguration.loadConfiguration(file)
                    val quest = yaml.getSerializable("quest", Quest::class.java)
                    val s0 = quest?.questName ?: "QuestNull"

                    val con = yaml.getObject("test1", DefaultHuntContent::class.java)
                    val s1 = con?.entityName ?: "ContentNull"

                    val item = yaml.getObject("test2", ItemStack::class.java)
                    val s2 = item?.type?.name ?: "ItemNull"

                    println("§a$s0")
                    println("§b$s1")
                    println("§c$s2")
                    TODO("yaml가 너무했어")
                }
            }
            loadQuest(questFolder)
        }

        private fun YamlConfiguration.getQuest() = getSerializable("quest", Quest::class.java)
    }


    /**
     * Field and Field function
     */
    override var questName = UtilityClass.date()
    override var questNpcName = "nullNpc"
    override var requirement = listOf<Requirement>()
    override var questScript = listOf<String>()
    override var questScriptSummary = listOf<String>()
    override var questContent = listOf<Content>()
    override var compensationScript = listOf<String>()
    override var compensations = listOf<Compensation>()
    override var folderPath = File(pl.dataFolder, "quest").path!!

    init {
        questSet.add(this)
        println("§c$questName")
    }
}