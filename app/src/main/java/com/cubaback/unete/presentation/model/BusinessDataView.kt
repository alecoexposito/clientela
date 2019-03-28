package com.cubaback.unete.presentation.model

data class BusinessDataView(val id : Long?,
                            val name: String?,
                            val description: String?,
                            val image : String?,
                            val dependence : List<DependencesDataView>?,
                            val categories : List<CategoryDataView>?)