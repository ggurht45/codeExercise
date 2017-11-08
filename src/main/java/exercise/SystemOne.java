package exercise;

public class SystemOne implements AQSystem {

    private Planes planes;

    @Override
    public void boot() {
        planes = new Planes();
    }


    @Override
    public void enqueueAC(AC aircraft) {
        System.out.println("new aircraft queued: " + aircraft);
        planes.addPlane(aircraft);
    }

    @Override
    public AC dequeueAC() {
        AC aircraft = planes.removePlane();
        System.out.println("plane dequeued: " + aircraft);
        return aircraft;
    }

    @Override
    public String queueState() {
        return planes.planesQueueState();
    }


}
