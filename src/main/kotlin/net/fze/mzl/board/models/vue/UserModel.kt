package net.fze.mzl.board.models.vue

/**
 * 返回给页面的用户模型
 */
class UserModel {
    var id: Int = 0
    var username: String = "master"
    var password: String = ""
    var name: String = "管理员"
    var avatar: String = "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif"
    var introduction: String = ""
    var email: String = ""
    var phone: String = ""
    var roles: ArrayList<String> = arrayListOf()
}