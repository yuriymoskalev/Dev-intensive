package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.models.User
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
        val user2 = User("2", "John", "Cena")
    }

    @Test
    fun test_factory(){
       var user1 = User.makeUser("John Sena")
       var user2 = User.makeUser("John Wick")
       var user3 = User.makeUser("John Silverhand")

        val user4 = user3.copy(id = "4", lastName = "Jones", lastVisit = Date())
    }

    @Test
    fun test_decomposition(){

    }
}
