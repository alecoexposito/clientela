package com.cubaback.unete.data.model.mapper

import com.cubaback.unete.data.model.BusinessAccountBo
import com.cubaback.unete.data.model.EntityBusinessAccount
import org.buffer.android.boilerplate.data.mapper.Mapper

open class EntityBusinessAccountMapper() : Mapper<EntityBusinessAccount, BusinessAccountBo> {

   // constructor()

    override fun map(type: EntityBusinessAccount): BusinessAccountBo {
        return BusinessAccountBo(type.id, type.accountNumber, type.defaultPercent, type.dependenceId)
    }

    override fun reverseMap(type: BusinessAccountBo): EntityBusinessAccount {
        return EntityBusinessAccount(type.id, type.accountNumber, type.defaultPercent, type.dependenceId)
    }
}