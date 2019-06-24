package Classroom

import Classroom.ClassroomDTO.students
import Config.SQLINFO.DRIVER
import Config.SQLINFO.PASSWORD
import Config.SQLINFO.URL
import Config.SQLINFO.USER
import Students.StudentDTO
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDate


object ClassroomDAO {
    private fun connectDb(){
        Database.connect(URL, DRIVER, USER, PASSWORD)
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
        for (kid in Tables.Students.selectAll()) {
            var bdayStr = kid[Tables.Students.birthday].toString().substring(0, 10).split("-").map { it.toInt() }
            students.add(
                StudentDTO
                    (
                    kid[Tables.Students.id],
                    kid[Tables.Students.firstName],
                    kid[Tables.Students.lastName],
                    LocalDate.of(bdayStr[0], bdayStr[1], bdayStr[2])
                )
            )
        }
        students.forEach { println("${it.firstName}:${it.birthday}") }
    }
}