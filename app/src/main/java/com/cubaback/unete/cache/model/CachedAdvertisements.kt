package com.cubaback.unete.cache.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.*

@RealmClass
open class CachedAdvertisements(@PrimaryKey var id : Long? = null,
                                var title : String?  = null,
                                var description : String?  = null,
                                var image : String?  = null,
                                var createdAt : Date?  = null,
                                var updatedAt : Date?  = null) : RealmObject()