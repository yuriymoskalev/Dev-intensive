package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class User(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var raiting: Int = 0,
    var respect: Int = 0,
    val lastVisit: Date? = null,
    val isOnline: Boolean = false

) {
    var introbit: String

    constructor(id: String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    constructor(id: String) : this(id, "John", "Doe")

    init {
        introbit = getIntro()
        println("It`s Alive! \n${if (lastName === "Doe") "His name is $firstName $lastName" else "And his name is $firstName $lastName"}\n")
    }

    private fun getIntro() = """
        tututu
        tututu
        tututu
    """.trimIndent()


    fun printMe(): Unit =
        println(
            """
            id: $id
            firstName: $firstName
            lastName: $lastName
            avatar: $avatar
            raiting: $raiting
            respect: $respect
            lastVisit: $lastVisit
            isOnline: $isOnline    
        """.trimIndent()
        )

    companion object Factory {
        private var lastId: Int = -1
        fun makeUser(fullname: String?): User {
            lastId++
            val (firstName, lastName) = Utils.parseFullName(fullname)

            return User(id = "$lastId", firstName = firstName, lastName = lastName)
        }
    }
}
