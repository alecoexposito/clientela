package com.cubaback.unete.domain.model.mapper

import com.cubaback.unete.presentation.model.BusinessAccountDataView
import com.cubaback.unete.domain.model.BusinessAccountBo
import com.cubaback.unete.mapper.Mapper

open class BusinessAccountBoMapper() : Mapper<BusinessAccountBo, BusinessAccountDataView>() {


    override fun map(type: BusinessAccountBo): BusinessAccountDataView {
        return BusinessAccountDataView(type.id, type.accountNumber, type.defaultPercent, type.dependenceId, type.createdAt, type.updatedAt)
    }

    override fun reverseMap(type: BusinessAccountDataView): BusinessAccountBo {
        return BusinessAccountBo(type.id, type.accountNumber, type.defaultPercent, type.dependenceId, type.createdAt, type.updatedAt)
    }

}