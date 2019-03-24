package com.cubaback.unete.data.model.mapper

import com.cubaback.unete.domain.model.ClientBo
import com.cubaback.unete.data.model.EntityClient
import com.cubaback.unete.mapper.Mapper
import java.util.*

open class EntityClientMapper(private val entityUserMapper: EntityUserMapper) : Mapper<EntityClient, ClientBo> {
    //constructor()

    override fun map(type: EntityClient): ClientBo {
        return ClientBo(type.id,  type.phone, type.birthDate, type.createdAt, type.updatedAt, type.user?.let { entityUserMapper.map(it) }  )
    }

    override fun reverseMap(type: ClientBo): EntityClient {
        return EntityClient(type.id,  type.phone, type.birthDate, type.createdAt, type.updatedAt, type.user?.let { entityUserMapper.reverseMap(it) } )
    }
}
