package my.company.app.domain.entity

data class GithubUser(val login: String,
                      val id: Int,
                      val avatar: String,
                      val url: String)