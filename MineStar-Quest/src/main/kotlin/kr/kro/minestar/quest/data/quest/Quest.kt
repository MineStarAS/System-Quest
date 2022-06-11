package kr.kro.minestar.quest.data.quest

import kr.kro.minestar.quest.data.compensation.Compensation
import kr.kro.minestar.quest.data.contents.Content
import kr.kro.minestar.quest.data.requirement.Requirement
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.configuration.serialization.ConfigurationSerializable
import java.io.File

interface Quest : ConfigurationSerializable {

    val questName: String
    val questNpcName: String

    val requirement: List<Requirement>

    val questScript: List<String>
    val questScriptSummary: List<String>

    val questContent: List<Content>

    val compensationScript: List<String>
    val compensations: List<Compensation>

    val folderPath: String

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