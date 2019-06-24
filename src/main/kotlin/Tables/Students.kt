package Tables

import org.jetbrains.exposed.sql.Table

object Students: Table(){
    val id = integer("id").primaryKey() // Column<String>
    val firstName = varchar("first_name", length = 50) // Column<String>
    val lastName = varchar("last_name", length = 50) // Column<String>
    val birthday = date("birthday")
}