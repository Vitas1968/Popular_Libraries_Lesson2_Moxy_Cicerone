package ru.geekbrains.poplib.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface RepositoryView: MvpView {
    fun renderId(id: String)
    fun renderName(name: String)
    fun renderForksCount(forksCount: String)
}