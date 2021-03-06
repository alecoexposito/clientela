package com.cubaback.unete.cache.model

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.*

@RealmClass
open class CachedBusiness(@PrimaryKey var id : Long? = null,
                     var name: String? = null,
                     var description: String? = null,
                     var image : String? = null,
                     var dependence : RealmList<CachedDependences>? = null,
                     var categories : RealmList<CachedCategory>? = null,
                          var createdAt : Date? = null,
                          var updatedAt : Date? = null) : RealmObject()