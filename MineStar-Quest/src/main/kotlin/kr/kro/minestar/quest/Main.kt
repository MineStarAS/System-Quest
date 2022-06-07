package kr.kro.minestar.quest

import kr.kro.minestar.quest.functions.Test
import kr.kro.minestar.quest.functions.TestClass
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    companion object {
        lateinit var pl: Main
        const val prefix = "§f[§9QUEST§f]"
    }

    override fun onEnable() {
        pl = this
        logger.info("$prefix §aEnable")
        getCommand("cmd")?.setExecutor(Command)

        TestClass
    }

    override fun onDisable() {
    }
}