package ru.geekbrains.poplib.mvp.model.repo

import ru.geekbrains.poplib.mvp.model.entity.GithubRepository

class GithubRepositoriesRepo {

    val repositories = listOf(
        GithubRepository("1", "name1", 100),
        GithubRepository("2", "name2", 200),
        GithubRepository("3", "name3", 300),
        GithubRepository("4", "name4", 400)
    )

    fun getRepos() = repositories

    /*
    Метод fromIterable возьмет список и создаст из него Observable с отдельными элементами
     списка, т.е. из List<User> мы получим Observable<User>.Оператор flatMap раскроет
     получившийся Observable<User> и запостит его элементы далее в поток .В итоге, в
      метод saveUser будут приходить отдельные объекты User

    Observable<List<User>> getUsers();

    getUsers()
    .flatMap(users -> Observable.fromIterable(users))
    .subscribe(user -> saveUser(user));
     */
}