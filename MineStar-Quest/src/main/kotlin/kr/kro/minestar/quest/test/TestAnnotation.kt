package kr.kro.minestar.quest.test

import org.bukkit.Location
import org.bukkit.inventory.ItemStack

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class Tester(val isCancel: Boolean = false)

class Application {

    @Tester
    fun sayHello(e: T3) {
    }
}

interface T0
interface T1 : T0, ABC1
interface T2 : T1, ABC2
interface T3 : T2

interface ABC1
interface ABC2

fun main() {

    val methods = Application::class.java.methods

    for (method in methods) {
        method.getAnnotation(Tester::class.java) ?: continue
        for (clazz in method.parameterTypes) {
            val checkInterface = T0::class.java
            val firstInterfaces = mutableListOf<Class<*>>()

            fun check(checkClass: Class<*>) {
                val interfaces = checkClass.interfaces
                if (interfaces.isNotEmpty()) for (i in interfaces) check(i)
                else firstInterfaces.add(checkClass)
            }
            check(clazz)

            for (i in firstInterfaces) println(i.simpleName)
            println(" ")
            println(firstInterfaces.contains(checkInterface))
        }
    }
}
