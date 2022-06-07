package kr.kro.minestar.quest.data.contents.hunt

import kr.kro.minestar.quest.data.contents.Content

open class DefaultHuntContent(open val entityName: String, open val amount: Int) : Content{

    override fun isComplete() = false

    override fun serialize(): MutableMap<String, Any> {
        val map = super.serialize()
        map["entityName"] = entityName
        map["amount"] = amount
        return map
    }
}