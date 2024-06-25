package org.example.observer;

import java.util.List;

public interface BasicObserver<T> {
    // Next
    void next(T nextObject);

    // Subscribe
    void subscribe(BasicObservable<T> observable);

    // Unsubscribe
    void unsubscribe(BasicObservable<T> observable);
}
