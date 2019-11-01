package observerexample;

import java.util.ArrayList;

public class Naukri implements SubjectL {


    ArrayList<ObserverL> observerLS;
    private String company;
    private String title;

    public Naukri(String company, String title) {
        this.company = company;
        this.title = title;


    }

    @Override
    public void addObserver(ObserverL observerL) {

        if (observerLS == null)
            observerLS = new ArrayList<>();

        observerLS.add(observerL);

    }

    @Override
    public void removeObserver(ObserverL observerL) {

        if (observerLS != null && observerLS.contains(observerL)) {
            observerLS.remove(observerL);
        }

    }

    @Override
    public void notifyObserver() {

        for (ObserverL observerL : observerLS) {
            System.out.println("Job availabe as " + title + " in company " + company);
            observerL.updateObserver(title);
        }

    }
}
