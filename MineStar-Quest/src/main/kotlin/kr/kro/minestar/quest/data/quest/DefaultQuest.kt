package kr.kro.minestar.quest.data.quest

import kr.kro.minestar.quest.Main.Companion.pl
import kr.kro.minestar.quest.data.compensation.Compensation
import kr.kro.minestar.quest.data.contents.Content
import kr.kro.minestar.quest.data.requirement.Requirement
import kr.kro.minestar.quest.functions.UtilityClass
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class DefaultQuest : Quest {

    companion object {
        private val questSet = hashSetOf<Quest>()

        private val questFolder = File(pl.dataFolder, "quest")

        fun loadQuests() {
            questSet.clear()

            fun loadQuest(folder: File) {
                if (!folder.exists()) folder.mkdir()
                val fileList = folder.listFiles()

                for (file in fileList) {
                    if (file.isDirectory) loadQuest(file)
                    if (!file.name.contains(".yml")) continue

                    val yaml = YamlConfiguration.loadConfiguration(file)

                    val quest = yaml.getSerializable("quest", Quest::class.java)
                    val s0 = quest?.questName ?: "QuestNull"

                    println("§a$s0")
                }
            }

            loadQuest(questFolder)
        }
    }

    override var questName: String = UtilityClass.date()
    override var questNpcName: String = "nullNpc"

    override var requirement: List<Requirement> = listOf()

    override var questScript: List<String> = listOf()
    override var questScriptSummary: List<String> = listOf()

    override var questContent: List<Content> = listOf()

    override var compensationScript: List<String> = listOf()
    override var compensations: List<Compensation> = listOf()

    override var folderPath: String = File(pl.dataFolder, "quest").path

    constructor()

    constructor(serialize: Map<String, Any>) {
        questName = if (serialize.containsKey("questName")) serialize["questName"] as String
        else ""
        questNpcName = if (serialize.containsKey("questNpcName")) serialize["questNpcName"] as String
        else ""
        requirement = if (serialize.containsKey("requirement")) serialize["requirement"] as List<Requirement>
        else listOf()
        questName = if (serialize.containsKey("questName")) serialize["questName"] as String
        else ""
        questName = if (serialize.containsKey("questName")) serialize["questName"] as String
        else ""
        questName = if (serialize.containsKey("questName")) serialize["questName"] as String
        else ""
        questName = if (serialize.containsKey("questName")) serialize["questName"] as String
        else ""
        questName = if (serialize.containsKey("questName")) serialize["questName"] as String
        else ""
        folderPath = if (serialize.containsKey("folderPath")) serialize["folderPath"] as String
        else ""

        requirement = serialize["requirement"] as List<Requirement>
        questScript = serialize["questScript"] as List<String>
        questScriptSummary = serialize["questScriptSummary"] as List<String>
        questContent = serialize["questContent"] as List<Content>
        compensationScript = serialize["compensationScript"] as List<String>

        questSet.add(this)
    }
}
