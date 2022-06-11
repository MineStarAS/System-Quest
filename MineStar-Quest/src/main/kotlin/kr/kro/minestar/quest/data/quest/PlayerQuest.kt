package kr.kro.minestar.quest.data.quest

import kr.kro.minestar.quest.Main
import kr.kro.minestar.quest.data.compensation.Compensation
import kr.kro.minestar.quest.data.contents.Content
import kr.kro.minestar.quest.data.requirement.Requirement
import org.bukkit.entity.Player
import java.io.File

class PlayerQuest : Quest {
    val player: Player
    override var questName: String
    override var questNpcName: String
    override var requirement: List<Requirement>
    override var questScript: List<String>
    override var questScriptSummary: List<String>
    override var questContent: List<Content>
    override var compensationScript: List<String>
    override var compensations: List<Compensation>
    override var folderPath: String

    constructor(player: Player, defaultQuest: DefaultQuest) {
        this.player = player
        questName = defaultQuest.questName
        questNpcName = defaultQuest.questNpcName
        requirement = defaultQuest.requirement
        questScript = defaultQuest.questScript
        questScriptSummary = defaultQuest.questScriptSummary
        questContent = defaultQuest.questContent
        compensationScript = defaultQuest.compensationScript
        compensations = defaultQuest.compensations
        folderPath = File(Main.pl.dataFolder, "player/${player.uniqueId}.yml").path!!
    }

    constructor(serialize: Map<String, Any>) {
        player = serialize["player"] as Player
        questName = serialize["questName"] as String
        questNpcName = serialize["questNpcName"] as String
        requirement = serialize["requirement"] as List<Requirement>
        questScript = serialize["questScript"] as List<String>
        questScriptSummary = serialize["questScriptSummary"] as List<String>
        questContent = serialize["questContent"] as List<Content>
        compensationScript = serialize["compensationScript"] as List<String>
        compensations = serialize["compensations"] as List<Compensation>
        folderPath = serialize["folderPath"] as String
    }
}