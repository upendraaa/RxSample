package observerexample;

public class Candidate implements ObserverL {

    String candidate;

    public Candidate(String name) {
        this.candidate = name;

    }

    @Override
    public void updateObserver(String update) {
        System.out.println(" Hi " + candidate + " job is available for you.");

    }
}
