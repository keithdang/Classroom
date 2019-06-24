package Classroom

import Students.StudentDTO
import javafx.collections.FXCollections

object ClassroomDTO{
    var students = FXCollections.observableArrayList<StudentDTO>()
}