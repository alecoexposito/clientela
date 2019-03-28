package com.cubaback.unete.presentation.model

import java.util.*

data class ClientDataView (val id : Long?,
                           val phone : String?,
                           val birthDate : Date?,
                           val createdAt : Date?,
                           val updatedAt : Date?,
                           val user : UserDataView?,
                           val account : ClientAccountDataView?)