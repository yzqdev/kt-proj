package com.yzq.site.controller

import com.yzq.site.dao.UserDao
import com.yzq.site.model.Users
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import org.kodein.di.instance

/**
 * @author yzqde
 * @date time 2022/9/4 22:59
 * @modified By:
 *
 */
suspend fun getAllUsers(call: ApplicationCall) {
    call.respond(setOf("xioaming", "xiaohong"))
}

suspend fun addUser(call: ApplicationCall) {


    val u = call.receive<Users>()


    call.respond(status = HttpStatusCode.OK, message = u)
}