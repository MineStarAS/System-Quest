package kr.kro.minestar.quest.data.quest

import kr.kro.minestar.quest.data.compensation.Compensation
import kr.kro.minestar.quest.data.contents.Content
import kr.kro.minestar.quest.data.requirement.Requirement
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.configuration.serialization.ConfigurationSerializable
import java.io.File

abstract class Quest : ConfigurationSerializable {

    abstract val questName: String
    abstract val questNpcName: String

    abstract val requirement: List<Requirement>

    abstract val questScript: List<String>
    abstract val questScriptSummary: List<String>

    abstract val questContent: List<Content>

    abstract val compensationScript: List<String>
    abstract val compensations: List<Compensation>

    /**
     * File function
     */
    abstract var folderPath: String
    fun folderPath(file: File): Boolean {
        if (!file.isDirectory) return false
        folderPath = file.path
        return true
    }

    fun save() {
        val file = File(folderPath, "$questName.yml")
        val yaml = YamlConfiguration()
        yaml["quest"] = this
        yaml.save(file)
    }

    override fun serialize(): Map<String, Any> {
        val map = HashMap<String, Any>()
        map["questName"] = questName
        map["questNpcName"] = questNpcName
        map["requirement"] = requirement
        map["questScript"] = questScript
        map["questScriptSummary"] = questScriptSummary
        map["questContent"] = questContent
        map["compensationScript"] = compensationScript
        map["compensation"] = compensations

        map["folderPath"] = folderPath
        return map
    }
}