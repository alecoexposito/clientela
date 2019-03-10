package com.cubaback.unete.remote.model.mapper

import com.cubaback.unete.remote.model.BusinessAccountModel
import com.cubaback.unete.data.model.EntityBusinessAccount
import com.cubaback.unete.mapper.Mapper

open class ModelBusinessAccountMapper() : Mapper<BusinessAccountModel, EntityBusinessAccount> {

   // constructor()

    override fun map(type: BusinessAccountModel): EntityBusinessAccount {
        return EntityBusinessAccount(type.id, type.accountNumber, type.defaultPercent, type.dependenceId)
    }

    override fun reverseMap(type: EntityBusinessAccount): BusinessAccountModel {
        return BusinessAccountModel(type.id, type.accountNumber, type.defaultPercent, type.dependenceId)
    }
}