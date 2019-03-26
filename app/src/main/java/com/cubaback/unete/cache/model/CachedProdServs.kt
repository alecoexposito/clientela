package com.cubaback.unete.cache.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open  class CachedProdServs(@PrimaryKey var id : Long? = null,
                           var name : String? = null,
                           var description : String? = null,
                           var priceMn : Double? = null,
                           var priceCuc : Double? = null,
                           var dependenceId : Long? = null) : RealmObject()