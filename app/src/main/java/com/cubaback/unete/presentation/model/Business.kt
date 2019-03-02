package com.cubaback.unete.presentation.model

data class Business(val id: String, val content: String, val details: String) {
        override fun toString(): String = content
    }