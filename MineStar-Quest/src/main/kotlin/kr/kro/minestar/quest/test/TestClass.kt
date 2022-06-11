@file:Suppress("DEPRECATION")

package kr.kro.minestar.quest.test

import kr.kro.minestar.quest.Main.Companion.pl
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

object TestClass {
    val yamlFile = File(pl.dataFolder, "test.yml")
    val yaml = YamlConfiguration().apply {
        this["test"] = Test("asd", 123)
        save(yamlFile)
    }

    val y = YamlConfiguration.loadConfiguration(yamlFile).apply {
        val get = getSerializable("test", Test::class.java)

        println("§c" + get.toString())
    }
}