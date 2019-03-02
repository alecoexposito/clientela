package com.cubaback.unete.data.model.mapper

import com.cubaback.unete.data.model.BusinessAccount
import com.cubaback.unete.data.model.BusinessAccountBo
import org.buffer.android.boilerplate.data.mapper.Mapper

open class BusinessAccountBoMapper() : Mapper<BusinessAccountBo, BusinessAccount> {


    override fun map(type: BusinessAccountBo): BusinessAccount {
        return BusinessAccount(type.id, type.accountNumber, type.defaultPercent, type.dependenceId)
    }

    override fun reverseMap(type: BusinessAccount): BusinessAccountBo {
        return BusinessAccountBo(type.id, type.accountNumber, type.defaultPercent, type.dependenceId)
    }

}