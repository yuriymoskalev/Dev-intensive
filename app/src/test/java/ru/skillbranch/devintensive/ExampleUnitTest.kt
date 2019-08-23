package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.TimeUnits
import ru.skillbranch.devintensive.extensions.add
import ru.skillbranch.devintensive.extensions.format
import ru.skillbranch.devintensive.extensions.toUserView
import ru.skillbranch.devintensive.models.BaseMessage
import ru.skillbranch.devintensive.models.Chat
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
        val user = User.makeUser("John Wick")
        fun getUserInfo() = user
        val (id, firstname, lastname) = getUserInfo()

        println("$id, $firstname, $lastname")
    }

    @Test
    fun test_copy() {
        val user = User.makeUser("John Wick")
        val user2 = user.copy(lastVisit = Date().add(-2, TimeUnits.SECOND))
        val user3 = user.copy(lastName = "Cena", lastVisit = Date().add(2, TimeUnits.HOUR))

        println("""
            ${user.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
        """.trimIndent())
    }

    @Test
    fun test_mapping() {
        val user = User.makeUser("John Wick")
        println(user)
        val userView = user.toUserView()

        userView.prentMe()
    }

    @Test
    fun test_abstract_factory() {
        val user = User.makeUser("John Wick")
        val txtMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any text message", type = "text")
        val imgMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any img URL", type = "image")

        println(txtMessage.formatMessage())
        println(imgMessage.formatMessage())
    }
}
