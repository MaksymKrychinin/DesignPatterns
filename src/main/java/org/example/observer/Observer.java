package org.example.observer;

import java.util.ArrayList;
import java.util.List;

public class Observer<T> implements BasicObserver <T>{

    public Observer() {
        this.observables = new ArrayList<>();
    }

    private final List<BasicObservable<T>> observables;

    @Override
    public void next(T nextObject) {
        observables.forEach(observable -> observable.execute(nextObject));
    }

    @Override
    public void subscribe(BasicObservable<T> observable) {
        observables.add(observable);
    }

    @Override
    public void unsubscribe(BasicObservable<T> observable) {
        observables.remove(observable);
    }

}
