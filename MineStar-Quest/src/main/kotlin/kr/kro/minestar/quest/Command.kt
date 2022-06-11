package kr.kro.minestar.quest

import kr.kro.minestar.quest.Main.Companion.prefix
import kr.kro.minestar.quest.data.compensation.ItemCompensation
import kr.kro.minestar.quest.data.contents.hunt.DefaultHuntContent
import kr.kro.minestar.quest.data.quest.DefaultQuest
import kr.kro.minestar.quest.data.requirement.ItemRequirement
import kr.kro.minestar.quest.test.TestClass
import kr.kro.minestar.utility.command.Argument
import kr.kro.minestar.utility.command.FunctionalCommand
import kr.kro.minestar.utility.item.amount
import kr.kro.minestar.utility.item.display
import kr.kro.minestar.utility.material.item
import kr.kro.minestar.utility.string.toPlayer
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object Command : FunctionalCommand {
    private enum class Arg(override val howToUse: String) : Argument {

    }

    private enum class OpArg(override val howToUse: String) : Argument {
        create(""),

        test(""),
    }

    override fun commanding(player: CommandSender, cmd: Command, label: String, args: Array<out String>) {
        if (player !is Player) return

        if (args.isEmpty()) return "$prefix $label".toPlayer(player)

        val arg = argument(Arg.values(), args) ?: if (player.isOp) argument(OpArg.values(), args) ?: return else return

        if (!arg.isValid(args)) return "$prefix §c${arg.howToUse(label)}".toPlayer(player)

        when (arg) {
            OpArg.create -> {
                val quest = DefaultQuest()
                quest.questName = "테스또 퀘스또"
                quest.questNpcName = "빠뿌라빠뿌"
                quest.requirement = listOf(
                    ItemRequirement(Material.DIAMOND.item().display("조은 디아몬도"))
                )
                quest.questScript = listOf(
                    "나는야 빠뿌라빠뿌",
                    "널 삐빠라삐삐뿌 해주지!"
                )
                quest.questScriptSummary = listOf("당신을 삐빠라삐삐뿌 하려고 합니다.")

                quest.questContent = listOf(
                    DefaultHuntContent("삐삐뿌?", 11),
                    DefaultHuntContent("삐삐뿌뽀!", 22),
                )

                quest.compensationScript = listOf(
                    "넌 이제 삐빠라삐삐뿌 됬어!",
                    "나에게 고마워 하도록!"
                )

                quest.compensations = listOf(
                    ItemCompensation(Material.DIAMOND.item().amount(33))
                )

                quest.save()
            }

            OpArg.test -> {
                TestClass
            }
        }
        return
    }

    override fun onTabComplete(player: CommandSender, cmd: Command, alias: String, args: Array<out String>): List<String> {
        if (player !is Player) return listOf()

        val list = mutableListOf<String>()

        val arg = argument(Arg.values(), args) ?: if (player.isOp) argument(OpArg.values(), args) else null
        val lastIndex = args.lastIndex
        val last = args.lastOrNull() ?: ""

        fun List<String>.add() {
            for (s in this) if (s.contains(last)) list.add(s)
        }

        fun Array<out Argument>.add() {
            for (s in this) if (s.name.contains(last)) list.add(s.name)
        }

        fun playerAdd() {
            for (s in Bukkit.getOnlinePlayers()) if (s.name.contains(last)) list.add(s.name)
        }

        if (arg == null) {
            Arg.values().add()
            if (player.isOp) OpArg.values().add()
        } else when (arg) {

            OpArg.test -> {}
        }
        return list
    }
}