package com.example

import io.micronaut.core.annotation.Introspected
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.annotation.Relation

@Introspected
@MappedEntity
data class Parent(
    @field:Id val id: Int,
    val name: String,
    @field:Relation(value = Relation.Kind.ONE_TO_MANY, mappedBy = "parentId", cascade = [Relation.Cascade.ALL])
    val children: List<Child>,
)