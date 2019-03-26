package com.cubaback.unete.cache.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.*

@RealmClass
open  class CachedDependences(@PrimaryKey var id : Long? = null,
                             var name : String? = null,
                             var description : String? = null,
                             var main : Boolean? = false,
                             var businessId : Long? = null,
                             var createdAt : Date? = null,
                             var updatedAt : Date? = null,
                             var account: CachedBusinessAccount? = null) : RealmObject()