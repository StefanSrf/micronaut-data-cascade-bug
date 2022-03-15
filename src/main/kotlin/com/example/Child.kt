package com.example

import io.micronaut.core.annotation.Introspected
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity

@Introspected
@MappedEntity
data class Child(
    @field:Id val id: Int,
    val name: String,
    val parentId: Int,
)