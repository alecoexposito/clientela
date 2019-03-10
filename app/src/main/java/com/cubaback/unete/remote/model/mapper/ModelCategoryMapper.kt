package com.cubaback.unete.remote.model.mapper

import com.cubaback.unete.remote.model.CategoryModel
import com.cubaback.unete.data.model.EntityCategory
import com.cubaback.unete.mapper.Mapper

open class ModelCategoryMapper() : Mapper<CategoryModel, EntityCategory> {
    // constructor()
    override fun map(type: CategoryModel): EntityCategory {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun reverseMap(type: EntityCategory): CategoryModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //    override fun map(type: CategoryModel): CategoryBo {
//        return CategoryBo(type.id, type.name, type.description, type.parentId)
//    }
//
//    override fun reverseMap(type: CategoryBo): CategoryModel {
//        return EntityCategory(type.id, type.name, type.description, type.parentId)
//    }
}