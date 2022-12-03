package com.yzq.site.service

/**
 * @author yzqde
 * @date time 2022/9/15 21:27
 * @modified By:
 *
 */

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

fun DI.MainBuilder.bindServices(){
    bind<UserService>() with singleton { UserService() }
}