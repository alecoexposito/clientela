package com.cubaback.unete.data.model.mapper

import com.cubaback.unete.domain.model.BusinessAccountBo
import com.cubaback.unete.data.model.EntityBusinessAccount
import com.cubaback.unete.mapper.Mapper

open class EntityBusinessAccountMapper : Mapper<EntityBusinessAccount, BusinessAccountBo>() {



    override fun map(type: EntityBusinessAccount): BusinessAccountBo {
        return BusinessAccountBo(type.id, type.accountNumber, type.defaultPercent, type.dependenceId, type.createdAt, type.updatedAt)
    }

    override fun reverseMap(type: BusinessAccountBo): EntityBusinessAccount {
        return EntityBusinessAccount(type.id, type.accountNumber, type.defaultPercent, type.dependenceId, type.createdAt, type.updatedAt)
    }
}