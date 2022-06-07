package kr.kro.minestar.quest.data.quest

import kr.kro.minestar.quest.Main.Companion.pl
import kr.kro.minestar.quest.data.acceptance.condition.Condition
import kr.kro.minestar.quest.data.compensation.Compensation
import kr.kro.minestar.quest.data.contents.Content
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.configuration.serialization.ConfigurationSerializable
import java.io.File

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
abstract class Quest(open val questName: String) : ConfigurationSerializable {
    companion object {
        private val questSet = hashSetOf<Quest>()

        private val questFolder = File(pl.dataFolder, "quest")

        fun loadQuests() {
            questSet.clear()
            fun loadQuest(folder: File) {
                val fileList = questFolder.listFiles().toList()

                for (file in fileList) {
                    if (file.isDirectory) loadQuest(file)
                    if (!file.name.contains(".yml")) continue

                    val yaml = YamlConfiguration.loadConfiguration(file)
                    val quest = yaml.getQuest() ?: continue

                    questSet.add(quest)
                }
            }
            loadQuest(questFolder)
        }

        private fun YamlConfiguration.getQuest() = getSerializable("quest", Quest::class.java)
    }

    protected abstract var questNpcName: String
    protected abstract var conditions: List<Condition>

    protected abstract var questScript: List<String>
    protected abstract var questScriptSummary: List<String>

    protected abstract var questContent: List<Content>

    protected abstract var compensationScript: List<String>
    protected abstract var compensations: List<Compensation>

    override fun serialize(): Map<String, Any> {
        val map = HashMap<String, Any>()
        map["questName"] = questName
        map["questNpcName"] = questNpcName
        map["conditions"] = conditions
        map["questScript"] = questScript
        map["questScriptSummary"] = questScriptSummary
        map["questContent"] = questContent
        map["compensationScript"] = compensationScript
        map["compensation"] = compensations
        return map
    }
}