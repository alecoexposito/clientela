package com.cubaback.unete.cache.model

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class CachedBusiness(@PrimaryKey var id : Long? = null,
                     var name: String? = null,
                     var description: String? = null,
                     var image : String? = null,
                     var dependence : CachedDependences? = null,
                     var categories : RealmList<CachedCategory>? = null) : RealmObject()