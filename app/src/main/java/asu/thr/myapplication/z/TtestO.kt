package asu.thr.myapplication.z

import android.util.Log
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class TtestO {

    private val TAG = "World"

    //    TODO: http://developer.alexanderklimov.ru/android/kotlin/sequence.php
    val cats = sequenceOf("Барсик", "Мурзик", "Рыжик", "Васька")

    fun fail(message: String): Nothing {
        throw IllegalArgumentException(message)
    }

    fun convertName(currency: AcceptedCurrency):String {
        return currency.name.substring(1, currency.name.length)
    }

    fun sayHelloByName(firstName: String, secondName: String) {
        println("Здравствуй $firstName $secondName")
    }

    fun sayHello(name: String): Unit {
        println("R_DOSHello $name")
    }

    fun sayHello2(name: String) = println("Hello2 $name")

    fun printNumbers(vararg integers: Int) {
        for (number in integers) {
            println("$number r_DOS")
        }
    }

    fun doIt(param: String) {

        fun justDoIt(innerParam: String) {
            println(innerParam)
            println(param)
        }
        justDoIt("a_inner_r_dos")
    }

    fun main() = runBlocking { // this: CoroutineScope
        println("World.Hello1")
        launch { // launch a new coroutine and continue
            delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
            println("World!World") // print after delay
        }
        println("World.Hello") // main coroutine continues while a previous one is delayed
    }


    fun main2() = runBlocking { // this: CoroutineScope
        launch { doWorld2() }
        println("World.Hello2")
    }

    // this is your first suspending function
    suspend fun doWorld2() {
        delay(1000L)
        println("World!2")
    }

    fun main3() = runBlocking {
        doWorld3()
    }

    suspend fun doWorld3() = coroutineScope {  // this: CoroutineScope
        launch {
            delay(1000L)
            println("World!3")
        }
        println("World.Hello3")
    }

    fun main4() = runBlocking {
        doWorld4()
    }

    suspend fun doWorld4() = coroutineScope {  // this: CoroutineScope
        launch {
            delay(1000L)
            println("World!4")
        }
        println("World.Hello4")
    }


    // Sequentially executes doWorld followed by "Done"
    fun main5() = runBlocking {
        doWorld5()
        println("World.Done")
        doWorld4()
    }

    // Concurrently executes both sections
    suspend fun doWorld5() = coroutineScope { // this: CoroutineScope
        launch {
            delay(10000L)
            Log.d(TAG, "World 2")
        }
        launch {
            delay(1000L)
            println("World 1")
        }
        println("World.Hello")
    }

//    TODO: Pair и Triple
    data class Person(val name: String = "", val age: String = (0).toString())
//    fun `12!cat`() = println("I am a cat!")
}