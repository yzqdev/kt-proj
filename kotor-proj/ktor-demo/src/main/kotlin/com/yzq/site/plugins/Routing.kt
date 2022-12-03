package com.yzq.site.plugins

import com.yzq.site.controller.addUser
import com.yzq.site.controller.getAllUsers
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.http.content.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {


    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/user") {
            call.respond(mapOf("name" to "hhh"))
        }
        post("/user") {
            addUser(call)
        }
        get("/allUser") {
            getAllUsers(call)
        }
        // Static plugin. Try to access `/static/index.html`
        static("/static") {
            resources("static")
        }
    }
}
