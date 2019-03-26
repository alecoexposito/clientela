package com.cubaback.unete.presentation.model

data class BusinessView(val id : Long?,
                        val name: String?,
                        val description: String?,
                        val image : String?,
                        val dependence : DependencesView?,
                        val categories : List<CategoryView>?)