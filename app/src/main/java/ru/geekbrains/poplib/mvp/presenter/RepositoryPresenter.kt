package ru.geekbrains.poplib.mvp.presenter

import moxy.InjectViewState
import moxy.MvpPresenter
import ru.geekbrains.poplib.mvp.model.entity.GithubRepository
import ru.geekbrains.poplib.mvp.view.RepositoryView
import ru.geekbrains.poplib.navigation.Screens
import ru.terrakok.cicerone.Router

@InjectViewState
class RepositoryPresenter(val repository: GithubRepository,val router: Router) : MvpPresenter<RepositoryView>(),IRepositoryRenderData {
    override fun renderData() {
        viewState.renderData(repository.id,repository.name,repository.forksCount)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        renderData()
    }

    fun backClicked(): Boolean {
        router.replaceScreen(Screens.RepositoriesScreen())
        return true
    }

}