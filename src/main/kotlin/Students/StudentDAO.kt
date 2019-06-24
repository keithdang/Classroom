package Students

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction

object StudentDAO {
    fun connectDb(){
        Database.connect(
            "jdbc:mysql://127.0.0.1:3306/sqlbolt?serverTimezone=EST5EDT",
            driver = "com.mysql.cj.jdbc.Driver",
            user = "root",
            password = "M.ysqldimes11!tops"
        )
    }

    fun callDb() {
        println("call db")
        connectDb()
        transaction {
            connectMysqlToStudentDTO()
            println("adding to dto")
        }
    }
    fun connectMysqlToStudentDTO(){
        println("Hello World")
    }
}