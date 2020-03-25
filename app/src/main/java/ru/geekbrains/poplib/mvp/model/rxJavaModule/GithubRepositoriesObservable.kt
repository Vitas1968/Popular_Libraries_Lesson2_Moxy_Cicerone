package ru.geekbrains.poplib.mvp.model.rxJavaModule

import io.reactivex.rxjava3.core.Observable
import ru.geekbrains.poplib.mvp.model.repo.GithubRepositoriesRepo

class GithubRepositoriesObservable(val repositories: GithubRepositoriesRepo) {

    fun getGithubRepositoriesObservable() = Observable.fromIterable(repositories.getRepos())

}
