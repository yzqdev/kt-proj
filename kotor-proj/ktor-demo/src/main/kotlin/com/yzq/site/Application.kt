package com.yzq.site

import com.yzq.site.model.Cities
import com.yzq.site.model.Users
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.yzq.site.plugins.configureHTTP
import com.yzq.site.plugins.configureRouting
import com.yzq.site.plugins.configureSerialization
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

fun main(arg: Array<String>) {
    val connectString =
        "jdbc:postgresql://localhost:5432/ktor_demo?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&characterSetResults=utf8&useSSL=false"
    Database.connect(connectString, driver = "org.postgresql.Driver", user = "postgres", password = "123456")
    transaction {
        // print sql to std-out
        addLogger(StdOutSqlLogger)

        SchemaUtils.create(Cities)
        SchemaUtils.create(Users)
        // insert new city. SQL: INSERT INTO Cities (name) VALUES ('St. Petersburg')
        val stPeteId = Cities.insert {
            it[name] = "St. Petersburg"
        } get Cities.id

        // 'select *' SQL: SELECT Cities.id, Cities.name FROM Cities
        println("Cities: ${Cities.selectAll()}")
    }
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureHTTP()
        configureSerialization()
        configureRouting()

    }.start(wait = true)
}
