package com.example

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

@MicronautTest(rollback = false)
class JdbcRelationDemoTest {

    @Inject
    lateinit var parentCrudRepository: ParentCrudRepository

    @Inject
    lateinit var childCrudRepository: ChildCrudRepository

    @Test
    fun `should insert children`() {
        parentCrudRepository.deleteAll()
        // insert a parent with a child.
        // child should be inserted based on the Cascade-Relation
        val parentToSave = Parent(1, "parent", listOf(Child(100, "child", 1)))
        parentCrudRepository.save(parentToSave)


        val childByIdOptional = childCrudRepository.findById(100)
        assertTrue(childByIdOptional.isPresent, "child should exist on db after insert with parent")

        // this fails as well
        // val parent = parentCrudRepository.findByName("parent").get()
        // assertEquals("parent", parent.name)
        // assertEquals(1, parent.children.size)
    }
}
