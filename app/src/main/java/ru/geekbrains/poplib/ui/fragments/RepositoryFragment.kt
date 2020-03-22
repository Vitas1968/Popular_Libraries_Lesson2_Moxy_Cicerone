package ru.geekbrains.poplib.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_repository.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

import ru.geekbrains.poplib.R
import ru.geekbrains.poplib.mvp.model.entity.GithubRepository
import ru.geekbrains.poplib.mvp.model.repo.GithubRepositoriesRepo
import ru.geekbrains.poplib.mvp.presenter.RepositoriesPresenter
import ru.geekbrains.poplib.mvp.presenter.RepositoryPresenter
import ru.geekbrains.poplib.mvp.view.RepositoryView
import ru.geekbrains.poplib.ui.App
import ru.geekbrains.poplib.ui.BackButtonListener


class RepositoryFragment : MvpAppCompatFragment(),RepositoryView,
    BackButtonListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        repository=arguments?.getParcelable("repository")
        super.onCreate(savedInstanceState)

    }

    var repository : GithubRepository?=null
    companion object {
        fun newInstance(repository : GithubRepository?): RepositoryFragment{
            val args= Bundle()
            args.putParcelable("repository",repository)
            val repositoryFragment= RepositoryFragment()
             repositoryFragment.arguments=args
            return repositoryFragment

        }
    }
    @InjectPresenter
    lateinit var presenter: RepositoryPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_repository, container, false)
    }
    @ProvidePresenter
    fun providePresenterRepository() =
        RepositoryPresenter(GithubRepository(repository!!.id,
        repository!!.name,
        repository!!.forksCount), App.instance.getRouter())


    override fun renderData(id: String, name: String, forksCount: Int) {
        tV_id.text=id
        tV_name.text=name
        tV_forksCount.text=forksCount.toString()
    }

    override fun backClicked() = presenter.backClicked()


}
