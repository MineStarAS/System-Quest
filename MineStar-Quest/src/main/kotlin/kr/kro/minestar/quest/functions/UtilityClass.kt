package kr.kro.minestar.quest.functions

import kr.kro.minestar.quest.data.quest.Quest
import org.bukkit.configuration.file.YamlConfiguration
import java.text.SimpleDateFormat
import java.util.*

object UtilityClass {
    fun date(): String = SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(Calendar.getInstance().time)
}