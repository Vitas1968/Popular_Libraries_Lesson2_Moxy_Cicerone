package ru.geekbrains.poplib.mvp.presenter

import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.geekbrains.poplib.mvp.model.entity.GithubRepository
import ru.geekbrains.poplib.mvp.model.repo.GithubRepositoriesRepo
import ru.geekbrains.poplib.mvp.presenter.list.IRepositoryListPresenter
import ru.geekbrains.poplib.mvp.view.RepositoriesView
import ru.geekbrains.poplib.mvp.view.list.RepositoryItemView
import ru.geekbrains.poplib.navigation.Screens
import ru.geekbrains.poplib.ui.App
import ru.terrakok.cicerone.Router
import timber.log.Timber

@InjectViewState
class RepositoriesPresenter(val ANDROID_MAIN_THREAD: Scheduler, val repositoriesRepo: GithubRepositoriesRepo, val router: Router) : MvpPresenter<RepositoriesView>() {

    class RepositoryListPresenter : IRepositoryListPresenter {
        val repositories = mutableListOf<GithubRepository>()
        override var itemClickListener: ((RepositoryItemView) -> Unit)? = null

        override fun getCount() = repositories.size

        override fun bindView(view: RepositoryItemView) {
            val repository = repositories[view.pos]
            view.setTitle(repository.name)
        }
    }

    val repositoryListPresenter = RepositoryListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadRepos()
        repositoryListPresenter.itemClickListener = { itemView ->
            val repository = repositoryListPresenter.repositories[itemView.pos]
            router.navigateTo(Screens.RepositoryScreen(repository))
        }
    }



    private fun loadRepos() {
        repositoriesRepo.getObsrvableRepos()
            .observeOn(ANDROID_MAIN_THREAD)
            .subscribe({listRepository ->
                repositoryListPresenter.repositories.clear()
                repositoryListPresenter.repositories.addAll(listRepository)
                viewState.updateList()
            },{
                Timber.e(it) })
    }




    /* реализация через RxBus
    private fun loadRepos() {
        App.instance
            .bus()!!
            .toObservable()
            .subscribe {listRepository ->
                Timber.d(listRepository[0].name)
                repositoryListPresenter.repositories.clear()
                repositoryListPresenter.repositories.addAll(listRepository)
                viewState.updateList()
            }
        repositoriesRepo.getBusRepos()
    }

     */
    
    fun backClicked() : Boolean {
        router.exit()
        return true
    }
}
