package kr.kro.minestar.quest.data.quest

import kr.kro.minestar.quest.data.acceptance.condition.Condition
import kr.kro.minestar.quest.data.compensation.Compensation
import kr.kro.minestar.quest.data.compensation.ItemCompensation
import kr.kro.minestar.quest.data.contents.Content

class DefaultQuest(override val questName: String) : Quest(questName) {

    override var questNpcName = ""
    fun questNpcName() = questNpcName
    fun questNpcName(name: String) {
        questNpcName = name
    }

    override var conditions = listOf<Condition>()

    override var questScript = listOf<String>()
    fun questScript() = questScript
    fun questScript(script: List<String>) {
        questScript = script
    }

    override var questScriptSummary = listOf<String>()
    fun questScriptSummary() = questScriptSummary
    fun questScriptSummary(script: List<String>) {
        questScriptSummary = script
    }

    override var questContent = listOf<Content>()

    fun questContent() = questContent
    fun questContent(contents: List<Content>) {
        questContent = contents
    }

    override var compensationScript = listOf<String>()

    override var compensations = listOf<Compensation>()

}