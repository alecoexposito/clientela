package com.cubaback.unete.data.model.mapper

import com.cubaback.unete.data.model.Client
import com.cubaback.unete.data.model.ClientBo
import com.cubaback.unete.data.model.EntityClient
import org.buffer.android.boilerplate.data.mapper.Mapper
import java.util.*

open class EntityClientMapper : Mapper<EntityClient, ClientBo>{
    constructor()

    override fun map(type: EntityClient): ClientBo {
        val date = Date(); // todo: transformar el date segun venga del API

        return ClientBo(type.id, type.phone, date)
    }

    override fun reverseMap(type: ClientBo): EntityClient {
        return EntityClient(type.id, type.phone, type.birthDate.toString())
    }
}
