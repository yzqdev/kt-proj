package com.yzq.site.dao

import com.yzq.site.model.Users

/**
 * @author Yangzhengqian
 * @description
 * @date:Created time 2022/9/5 12:48
 * @modified By:
 *
 */
interface UserDao {
    suspend fun addUser(user: Users)
}