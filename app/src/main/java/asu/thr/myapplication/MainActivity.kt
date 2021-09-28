package asu.thr.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import asu.thr.myapplication.dag.DatabaseHelper
import asu.thr.myapplication.dag.MainActivityPresenter
import asu.thr.myapplication.dag.NetworkUtils
import asu.thr.myapplication.database.CatBootstrap
import asu.thr.myapplication.di.ZZZContextModule
import asu.thr.myapplication.di.DaggerRandomUserComponent
import asu.thr.myapplication.di.BLABLAComponent
import asu.thr.myapplication.z.*
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.observers.DisposableObserver
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class MainActivity : AppCompatActivity(), GalleryListFragment.Callbacks {

    private val currencies = listOf(Rubel, Dollar(), Tugrik())

    fun foo(p: Predicate<Int>) = p(42)

    fun main(args: Array<String>) {
        val f: (Int) -> Boolean = { it > 0 }
        println(foo(f)) // выведет "true"

        val p: Predicate<Int> = { it > 0 }
        println(listOf(1, -2).filter(p)) // выведет "[1]"
    }


//    lateinit var presenter: MainActivityPresenter
    @Inject lateinit var databaseHelper: DatabaseHelper
    @Inject lateinit var networkUtils: NetworkUtils
    lateinit var mainActivityPresenter: MainActivityPresenter

    fun onClick(view: View?) {
        val random = Random(30)
        val numberSet: SortedSet<Int> = TreeSet()
        for (i in 0..999) numberSet.add(random.nextInt(10))
        mInfoTextView.setText(numberSet.toString())
    }


    fun onCreateCreate(savedInstanceState: Bundle?) {

        val appComp = (application as MyApplication).appComp
        mainActivityPresenter = appComp.getMainActivityPresenter()

        val daggerRandomUserComponent: BLABLAComponent = DaggerRandomUserComponent.builder()
            .contextModule(ZZZContextModule(this))
            .build()
//        picasso = daggerRandomUserComponent.getPicasso()

                            //        val randomUsersCall: Call<RandomUsers?>? = daggerRandomUserComponent.getRandomUserService().getRandomUsers(10)
                            //        randomUsersCall?.enqueue(object : Callback<RandomUsers?> {
                            //            override fun onResponse(call: Call<RandomUsers?>?, response: Response<RandomUsers?>) {
                            //                if (response.isSuccessful()) {
                            ////                    mAdapter = RandomUserAdapter(picasso)
                            ////                    mAdapter.setItems(response.body().getResults())
                            ////                    recyclerView.setAdapter(mAdapter)
                            //                    response.body()?.toString()?.let { TtestO().sayHello(it) }
                            //                }
                            //            }
                            //
                            //            override fun onFailure(call: Call<RandomUsers?>?, t: Throwable) {
                            //                Timber.i(t.message)
                            //                t.stackTrace
                            //                t.message?.let { TtestO().sayHello(it) }
                            //            }
                            //        })

//        databaseHelper = appComp.getDatabaseHelper()
//        networkUtils = appComp.getNetworkUtils()
//        val cacheDirectory = File("some path")
//        val cache: Cache = HttpResponseCache(cacheDirectory, 50 * 1024 * 1024)
//
//        val httpClient = OkHttpClient()
//        httpClient.setCache(cache)
//
//        val builder = RestAdapter.Builder()
//        builder.setClient(httpClient)
//        val restAdapter: RestAdapter = builder.build()
//        val apiService: ApiService = restAdapter.create(ApiService::class.java)
//
//        val userController = UserController(apiService)
//
//        val preference = getSharedPreferences("user_prefs", MODE_PRIVATE)
//        val dataController = DataController(preference)
//
//        activityPresenter = MainActivityPresenter(this, userController, dataController)
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.appComponent1
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

        val (test, id) = CatBootstrap("111", 12, "aaaa")

        testO.sayHello(test)
        testO.sayHello(id.toString())

        // TODO: 01.09.2021
        // TODO: 06.09.2021  кто ты?-откуда ты взялась?
        val personS = TtestO.Person("a?","да известно").name ?: testO.fail("Name required")
        println(personS)     // известно, что переменная 's' проинициализирована к этому моменту
        onCreateCreate(savedInstanceState)
        onCreateRxJava()
        onCreateCoroutine()
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
    inline fun inlined(block: () -> Unit) {
        println("aaabefore")
        block()
        println("aaaafter")
    }

    suspend fun main() = coroutineScope{
//        suspendCoroutine<> {  }
        launch{
            for(i in 0..5){
                Log.i("AAA", "Got a toast: ${Thread.currentThread().id}")
                delay(400L)
                println(i)
            }
        }
        launch{
            for(i in 6..10){
                Log.i("AAA", "Got a toast: ${Thread.currentThread().id}")
                delay(400L)

                println(i)
            }
        }
        Log.i("AAA","Hello Coroutines")
    }

    private fun onCreateCoroutine() {
        inlined {
            println("aaa")
        }
//        val url = buildUrl()
//
//// long synchronous function
//        // long asynchronous function
//        download(url) {
//            toast("Url is downloaded")
//        }
    }

    private fun toast(s: String) {
        Log.i("AAA", "Got a toast: ${Thread.currentThread().id}")
        Toast.makeText(
            this,
                    s,
            Toast.LENGTH_LONG
        )
            .show()
    }

    fun <T : Any> List<T>.toRdosya(): String { return Rubel.name    }




    private fun onCreateRxJava() {
        val list = listOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
        TtestO().sayHello(list.toString())
        TtestO().sayHello(list.toRdosya())

//        list.toObservable() // extension function for Iterables
//            .filter { it.length >= 5 }
//            .subscribeBy(  // named arguments for lambda Subscribers
//                onNext = { println(it) },
//                onError =  { it.printStackTrace() },
//                onComplete = { println("Done!") }
//            )

//        val observable = Observable.create(ObservableOnSubscribe<Int> { emitter ->
//            emitter.onNext(1);
//            emitter.onNext(2);
//            emitter.onNext(3);
//            emitter.onNext(4);
//
//            //Once the Observable has emitted all items in the sequence, call onComplete//
//            emitter.onComplete();
//        })
        val observable = Observable.range(-1, 10)
        val observer = object : Observer<Int> {
            override fun onSubscribe(d: Disposable) {
                TtestO().sayHello(list.toString())
            }

            override fun onNext(t: Int) {
                TtestO().sayHello(t.toString())
            }

            override fun onError(e: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onComplete() {
                TtestO().sayHello("onComplete: All Done!")
            }

        }
        //Create our subscription//
        observable.subscribe(observer)

        val disposable : Disposable = Observable.just("Hello world!")
            .delay(1, TimeUnit.SECONDS)
            .subscribeWith(object : DisposableObserver<String>() {
                override fun onNext(t: String) {
                    TtestO().sayHello(t)

                }

                override fun onError(e: Throwable) {
                    TtestO().sayHello(e.toString())
                }

                override fun onComplete() {
                    TtestO().sayHello("onComplete!")
                }

                override fun onStart() {
                    TtestO().sayHello("Start!")
                }

            })
        Thread.sleep(3000);
        disposable.dispose()
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