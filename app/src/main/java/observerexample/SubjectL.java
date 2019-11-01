package observerexample;

public interface SubjectL {

    void addObserver(ObserverL observerL);

    void removeObserver(ObserverL observerL);

    void notifyObserver();

}
