package asu.thr.myapplication

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import asu.thr.myapplication.z.*
import java.util.*

class MainActivity : AppCompatActivity(), GalleryListFragment.Callbacks {

    private val currencies = listOf(Rubel(), Dollar(), Tugrik())

    fun foo(p: Predicate<Int>) = p(42)

    fun main(args: Array<String>) {
        val f: (Int) -> Boolean = { it > 0 }
        println(foo(f)) // выведет "true"

        val p: Predicate<Int> = { it > 0 }
        println(listOf(1, -2).filter(p)) // выведет "[1]"
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        val testO = TtestO()
        TtestO().sayHelloByName("11", "r_dos")
        TtestO().printNumbers(1, 2, 3, 4, 5)
        TtestO().printNumbers(4)
        TtestO().doIt("ac_r_DOS")
        val adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_item,
            currencies.map { TtestO().convertName(it) })
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        findViewById<Spinner>(R.id.spinner).adapter = adapter

        main(arrayOf("ac"))

        val someGenericClass =  SomeGenericClass<String>()
        val str = someGenericClass.getSomeField()?.length
        testO.sayHello("$str")

        val user = UuserO("Text_r_dos_какойототам")
//        user.text = "asdas"
        testO.sayHello(user.text)
        val triple = Triple(testO, testO, testO)


        // TODO: 01.09.2021
        // TODO: 06.09.2021  кто ты?-откуда ты взялась?
        val personS = TtestO.Person("a?","да известно").name ?: testO.fail("Name required")
        println(personS)     // известно, что переменная 's' проинициализирована к этому моменту

//        println("World.start")
//        testO.main5()
//        println("World.end")
        val isFragmentContainerEmpty = savedInstanceState == null
        if (isFragmentContainerEmpty) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, GalleryListFragment.newInstance())
                .commit()
        }

    }

    override fun onGalleryItemSelected() {
        val fragment = CatFragmentDtl.newInstance()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }


}


typealias Predicate<T> = (T) -> Boolean