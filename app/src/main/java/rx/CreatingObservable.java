package rx;


import io.reactivex.Observable;

public class CreatingObservable {


    public static void main(String[] args) {

        CreatingObservable creatingObservable = new CreatingObservable();
        creatingObservable.byUsingJust();
        creatingObservable.byUsingFrom();
    }

    public void byUsingJust() {

        Observable.just(1, 4, 9, 16, 23, 34, 45, 345).subscribe(val -> {
                    System.out.println(val.toString());
                },
                ex -> {
                    System.out.println(ex.getMessage());

                }
        );
    }

    public void byUsingFrom() {

        Observable.fromArray("Upendra", "Singh").subscribe(val -> {
            System.out.println(val);
        });
    }
}
