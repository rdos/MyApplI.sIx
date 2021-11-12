package asu.thr.myapplication

import asu.thr.myapplication.api.CataasEntity
import asu.thr.myapplication.database.Cat
import asu.thr.myapplication.database.CatEntity
Ж€НА ОЛИГАРХА__😢))😅
//TODO: я нашёл свою 8ену
// TODO: 21.09.2021 custom view любо
// TODO: 21.09.2021 с RxJava 
// TODO: 21.09.2021 24:00 с Dagger2    

class MappER {

    fun toCatEntity(pCataasEntity: CataasEntity): CatEntity {
        val catEntity: CatEntity = mutableListOf()
        for (cataasEntity in pCataasEntity) {
            val cat = Cat(
                id = null,
                id_id = cataasEntity.id_id,
                date_date = cataasEntity.created_at,
                url_url = "https://cataas.com/cat/"
            )
            catEntity.add(cat)
        }
        return catEntity
    }
}
// TODO: 09.10.2021 StrictMode.enableDefaults()
// TODO: https://github.com/Polecat/assessment-android-2020
//TODO: !!!   fun <T : Any> List<T>.toRdosya(): String { return Rubel.name    }