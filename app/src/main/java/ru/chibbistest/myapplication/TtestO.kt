package ru.chibbistest.myapplication

class TtestO {

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

//    TODO: Pair и Triple
    data class Person(val name: String = "", val age: String = (0).toString())
//    fun `12!cat`() = println("I am a cat!")
}