package observerexample;

public class MainObserverPattern {


    public static void main(String[] args) {

        Naukri naukri = new Naukri("Samsung", "SE");
        Candidate candidate1 = new Candidate("Upendra");
        naukri.addObserver(candidate1);
        Candidate candidate2 = new Candidate("Monty");
        naukri.addObserver(candidate2);

        naukri.notifyObserver();


    }
}
