package my.company.app.data.repository.model

internal data class RemoteGithubUser(val login: String,
                                     val id: Int,
                                     val avatar: String,
                                     val url: String)