package com.cubaback.unete.data.model.mapper

import com.cubaback.unete.data.model.Client
import com.cubaback.unete.data.model.ClientBo
import com.cubaback.unete.data.model.EntityClient
import org.buffer.android.boilerplate.data.mapper.Mapper
import java.util.*

open class ClientBoMapper : Mapper<ClientBo, Client>{
    constructor()

    override fun map(type: ClientBo): Client {
        return Client(type.id, type.phone, type.birthDate)
    }

    override fun reverseMap(type: Client): ClientBo {
        return ClientBo(type.id, type.phone, type.birthDate)
    }

}
