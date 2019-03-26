package com.cubaback.unete.mapper

/**
 * Interface for model mappers. It provides helper methods that facilitate
 * retrieving of models from outer data source layers
 *
 * map: mapea desde la capa mas interior hasta la mas exterior
 * reverseMap: mapea desde la capa mas exterior hasta la mas interior
 *
 * Ex: map transforma de Data->Domain y de Domain->Presentacion
 * Ex: reverseMap transforma de Domain->Data y de Presentacion->Domain
 *
 * @param <T> the cached model input type
 * @param <T> the remote model input type
 * @param <V> the model return type
 */
abstract class Mapper<INTERNAL, EXTERNAL> {

    abstract fun map(type: INTERNAL): EXTERNAL
    open fun map (type : List<INTERNAL>) : List<EXTERNAL> {
        return type.map { map(it) }
    }

    abstract fun reverseMap(type: EXTERNAL): INTERNAL
    open fun reverseMap (type : List<EXTERNAL>) : List<INTERNAL>{
        return type.map { reverseMap(it) }
    }



}