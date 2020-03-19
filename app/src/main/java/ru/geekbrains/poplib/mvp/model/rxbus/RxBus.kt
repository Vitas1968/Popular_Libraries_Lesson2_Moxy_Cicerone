package ru.geekbrains.poplib.mvp.model.rxbus

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import ru.geekbrains.poplib.mvp.model.entity.GithubRepository


class RxBus {
    private val bus = PublishSubject.create<List<GithubRepository>>()

    fun send(list: List<GithubRepository>) {
        bus.onNext(list)
    }

    fun toObservable(): Observable<List<GithubRepository>> {
        return bus
    }




}