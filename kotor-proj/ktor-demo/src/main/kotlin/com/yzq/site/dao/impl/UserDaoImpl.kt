package com.yzq.site.dao.impl

import com.yzq.site.dao.UserDao
import com.yzq.site.model.Users
import org.jetbrains.exposed.sql.insert

/**
 * @author Yangzhengqian
 * @description
 * @date:Created time 2022/9/5 12:51
 * @modified By:
 *
 */
class UserDaoImpl : UserDao {
    override suspend fun addUser(user:Users) {
        Users.insert {

        }
    }
}