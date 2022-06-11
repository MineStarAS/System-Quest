package kr.kro.minestar.quest.data.quest

import kr.kro.minestar.quest.Main
import kr.kro.minestar.quest.data.requirement.Requirement
import kr.kro.minestar.quest.data.compensation.Compensation
import kr.kro.minestar.quest.data.contents.Content
import org.bukkit.entity.Player
import java.io.File

class PlayerQuest(player: Player, defaultQuest: DefaultQuest) : Quest() {
    override val questName = defaultQuest.questName
    override val questNpcName = defaultQuest.questNpcName

    override val requirement = defaultQuest.requirement

    override val questScript = defaultQuest.questScript
    override val questScriptSummary = defaultQuest.questScriptSummary

    override val questContent = defaultQuest.questContent

    override val compensationScript = defaultQuest.compensationScript
    override val compensations = defaultQuest.compensations
    override var folderPath = File(Main.pl.dataFolder, "player/${player.uniqueId}.yml").path!!
}