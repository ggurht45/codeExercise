package exercise;

public interface AQSystem {

    void boot();

    void enqueueAC(AC aircraft);

    AC dequeueAC();

    String queueState();

}
