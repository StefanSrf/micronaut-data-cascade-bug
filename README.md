# Relation Cascade Insert not working

Demo that shows that @Relation does not work for cascading inserts 
```
@field:Relation(value = Relation.Kind.ONE_TO_MANY, mappedBy = "parentId", cascade = [Relation.Cascade.ALL])
```

Test that exposes the bug: `JdbcRelationDemoTest`

## Additional Informatoin
According to the debug logs (below) the child relation is used.
However, binding does not happen and ultimately the child-relation is not persisted. 

```
[Test worker] DEBUG io.micronaut.data.query - Executing SQL Insert: INSERT INTO `parent` (`name`,`id`) VALUES (?,?)
[Test worker] TRACE io.micronaut.data.query - Binding parameter at position 1 to value parent with data type: STRING
[Test worker] TRACE io.micronaut.data.query - Binding parameter at position 2 to value 1 with data type: INTEGER
[Test worker] DEBUG io.micronaut.data.query - Executing Batch SQL Insert: INSERT INTO `child` (`name`,`parent_id`,`id`) VALUES (?,?,?)
```