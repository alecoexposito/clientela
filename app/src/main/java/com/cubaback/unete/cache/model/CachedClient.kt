package com.cubaback.unete.cache.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.*

@RealmClass
open  class CachedClient (@PrimaryKey var id : Long? = null,
                         var phone : String?= null,
                         var birthDate : Date?= null,
                         var createdAt : Date?= null,
                         var updatedAt : Date?= null,
                         var user : CachedUser? = null,
                         var account: CachedClientAccount? = null) : RealmObject()