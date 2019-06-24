package Students

import javafx.collections.FXCollections
import java.time.LocalDate
import java.time.Period

class StudentDTO(var id:Int, var firstName:String, var lastName: String, var birthday: LocalDate){
    var age = Period.between(birthday, LocalDate.now()).years
}

