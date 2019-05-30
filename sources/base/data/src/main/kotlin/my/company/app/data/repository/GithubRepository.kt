package my.company.app.data.repository

import my.company.app.domain.model.GithubUser

interface GithubRepository {
    fun getTopUsers(): List<GithubUser>
}