package com.cubaback.unete.presentation.model.mapper

import com.cubaback.unete.domain.model.BusinessAccountBo
import com.cubaback.unete.data.model.BusinessAccountView
import com.cubaback.unete.mapper.Mapper

class BusinessAccountViewMapper : Mapper<BusinessAccountBo, BusinessAccountView> {

    override fun map(type: BusinessAccountBo): BusinessAccountView {
        return BusinessAccountView(type.id, type.accountNumber, type.defaultPercent, type.dependenceId)
    }

    override fun reverseMap(type: BusinessAccountView): BusinessAccountBo {
        return BusinessAccountBo(type.id, type.accountNumber, type.defaultPercent, type.dependenceId)
    }
}