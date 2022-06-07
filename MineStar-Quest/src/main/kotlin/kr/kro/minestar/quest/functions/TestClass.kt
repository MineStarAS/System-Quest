@file:Suppress("DEPRECATION")

package kr.kro.minestar.quest.functions

import kr.kro.minestar.quest.Main.Companion.pl
import org.bukkit.Bukkit
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

object TestClass {
    val yamlFile = File(pl.dataFolder, "test.yml")
    val yaml = YamlConfiguration().apply {
        this["test"] = Test()
        save(yamlFile)

        val get = getSerializable("test", Test::class.java)

        Bukkit.broadcastMessage(get.toString())
    }
}