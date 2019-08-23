package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

fun User.toUserView() : UserView{

    val nickname = Utils.transliteration("$firstName $lastName")
    val initials =  Utils.toInitials(firstName, lastName)
    val status = if(lastVisit == null) "no visit" else if (isOnline) "online" else "last time was ${lastVisit.humanizeDiff()}"

    return UserView(
        id,
        fullName = "$firstName $lastName",
        nickName = nickname,
        initials = initials,
        avatar = avatar,
        status = status
        )
}


