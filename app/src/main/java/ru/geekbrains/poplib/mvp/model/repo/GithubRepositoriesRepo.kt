package ru.geekbrains.poplib.mvp.model.repo

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.geekbrains.poplib.mvp.model.entity.GithubRepository
import ru.geekbrains.poplib.ui.App

class GithubRepositoriesRepo {

    val repositories = listOf(
        GithubRepository("1", "name1", 100),
        GithubRepository("2", "name2", 200),
        GithubRepository("3", "name3", 300),
        GithubRepository("4", "name4", 400)
    )

    fun getRepos() = repositories
    fun getObsrvableRepos() = Observable.fromIterable(repositories).toList().subscribeOn(Schedulers.io())

    fun getBusRepos() {
        App.instance.bus()!!
            .send(repositories)
    }

}