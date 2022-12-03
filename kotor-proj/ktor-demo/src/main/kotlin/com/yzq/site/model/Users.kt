package com.yzq.site.model

import org.jetbrains.exposed.sql.Table

/**
 * @author Yangzhengqian
 * @description
 * @date:Created time 2022/9/5 8:55
 * @modified By:
 *
 */
 data class User(val id:Int,val username:String,val password:String)
 object Users: Table(){
     val id = integer("id").autoIncrement()
    val username = varchar("username", 50)
    val password = varchar("password", 50)
    override val primaryKey = PrimaryKey(id, name = "user_id")
 }