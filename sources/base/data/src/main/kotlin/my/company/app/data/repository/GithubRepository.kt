package my.company.app.data.repository

import my.company.app.domain.entity.GithubUser

interface GithubRepository {
    fun getTopUsers(): List<GithubUser>
}