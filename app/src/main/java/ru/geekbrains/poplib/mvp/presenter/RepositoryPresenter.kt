package ru.geekbrains.poplib.mvp.presenter

import kotlinx.android.synthetic.main.fragment_repository.*
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.geekbrains.poplib.mvp.model.entity.GithubRepository
import ru.geekbrains.poplib.mvp.view.RepositoryView
import ru.geekbrains.poplib.navigation.Screens
import ru.terrakok.cicerone.Router

@InjectViewState
class RepositoryPresenter(val repository: GithubRepository,val router: Router) : MvpPresenter<RepositoryView>(),IRepositoryRenderData {
    override fun renderId() {
        viewState.renderId(repository.id)
    }

    override fun renderName() {
        viewState.renderName(repository.name)
    }

    override fun renderForksCount() {
        viewState.renderForksCount(repository.forksCount.toString())
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        renderId()
        renderName()
        renderForksCount()
    }

    fun backClicked(): Boolean {
        router.replaceScreen(Screens.RepositoriesScreen())
        return true
    }

}