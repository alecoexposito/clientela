package com.cubaback.unete.cache.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.*

@RealmClass
open  class CachedCategory(@PrimaryKey var id : Long? = null,
                          var name : String? = null,
                          var description : String? = null,
                          var parentId : Long? = null,
                          var createdAt : Date? = null,
                          var updatedAt : Date? = null) : RealmObject()