package com.cubaback.unete.cache.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.*

@RealmClass
open  class CachedClientAccount(@PrimaryKey var id: Long? = null,
                               var accountNumber :  String? = null,
                               var clientId: Long? = null,
                               var createdAt : Date? = null,
                               var updatedAt : Date? = null) : RealmObject()