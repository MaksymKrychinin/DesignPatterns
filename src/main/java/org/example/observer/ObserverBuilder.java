package org.example.observer;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ObserverBuilder<T> {
    private final Observer<T> observer;
    private BasicObservable<T> observable;
    private final List<Predicate<T>> predicateList;
    private Observer<Boolean> takeUntilObserver;

    public ObserverBuilder(Observer<T> observer) {
        this.observer = observer;
        this.predicateList = new ArrayList<>();
    }

    public ObserverBuilder<T> when(Predicate<T> predicate) {
        predicateList.add(predicate);
        return this;
    }

    public ObserverBuilder<T> subscribe(BasicObservable<T> observable) {
        this.observable = observable;
        return this;
    }

    public ObserverBuilder<T> first(Consumer<T> consumer) {
        this.observable = consumer::accept;
        return this;
    }

    public ObserverBuilder<T> takeUntil(Observer<Boolean> takeUntilObserver) {
        this.takeUntilObserver = takeUntilObserver;
        return this;
    }


    public Observer<T> build() {
        BasicObservable<T> consumer = object -> {
            for (Predicate<T> predicate : predicateList) {
                if (!predicate.test(object)) {
                    return;
                }
            }
            this.observable.execute(object);
        };

        if (takeUntilObserver != null) {
            takeUntilObserver.subscribe(object -> {
                if (object) {
                    this.observer.unsubscribe(consumer);
                }

            });
        }

        observer.subscribe(consumer);

        return observer;
    }
}
