package interview.upendra.com.rxjavasampleapp;


import java.util.Arrays;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;

public class MainClass {


    public static void main(String[] args) {

        String[] countries = {"India", "England", "Canada", "Saudi"};
        Observable.fromArray(countries).subscribe(x -> System.out.println(x));

        Observable.just(countries).subscribe(country -> System.out.println(Arrays.toString(country)));

        // createObservable();
        hotObservable();

    }

    public static void createObservable() {
        Observable<Integer> source = Observable.range(1, 10);
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(" Value " + integer);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(" Value " + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println(" Emission Completed ");

            }
        };

        source.subscribe(observer);

    }


    public static void hotObservable() {
        Observable<Integer> source = Observable.range(1, 10);
        ConnectableObservable<Integer> hot = source.publish();

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(" Value " + integer);

            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e.getMessage());

            }

            @Override
            public void onComplete() {
                System.out.println("Completed!");

            }
        };

        hot.subscribe(observer);

        hot.connect();


    }
}
