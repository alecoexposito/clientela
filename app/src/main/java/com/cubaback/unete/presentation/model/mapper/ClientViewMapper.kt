package com.cubaback.unete.presentation.model.mapper

import com.cubaback.unete.domain.model.ClientBo
import com.cubaback.unete.data.model.ClientView
import com.cubaback.unete.mapper.Mapper

class ClientViewMapper : Mapper<ClientBo, ClientView> {

    override fun map(type: ClientBo): ClientView {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun reverseMap(type: ClientView): ClientBo {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}