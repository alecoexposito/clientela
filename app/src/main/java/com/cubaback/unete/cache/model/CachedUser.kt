package com.cubaback.unete.cache.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.*

@RealmClass
open  class CachedUser (var id : Long? = null,
                       var name : String? = null,
                       var lastName : String? = null,
                       @PrimaryKey var email : String? = null,
                       var password : String? = null,
                       var phone : String? = null,
                       var token : String? = null,
                       var birthDate : Date? = null,
                       var createAt : Date? = null,
                       var updatedAt : Date? = null) : RealmObject()

