@file:Suppress("DEPRECATION")

package kr.kro.minestar.quest.test

import kr.kro.minestar.quest.Main.Companion.pl
import kr.kro.minestar.utility.item.display
import kr.kro.minestar.utility.material.item
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.tags.ItemTagType
import org.yaml.snakeyaml.Yaml
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

    init {
    }
}