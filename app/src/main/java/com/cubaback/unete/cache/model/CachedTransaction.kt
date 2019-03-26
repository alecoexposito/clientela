package com.cubaback.unete.cache.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open  class CachedTransaction(@PrimaryKey var id : Long? = null,
                             var clientAccountId : Long? = null,
                             var businessAccountId : Long? = null,
                             var createdAt : String? = null,
                             var updatedAt : String?= null) : RealmObject()