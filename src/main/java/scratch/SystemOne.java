package scratch;

public class SystemOne implements AQSystem {

    private Planes planes;

    @Override
    public boolean boot() {
        System.out.println("boot method implementation");
        planes = new Planes();
        return false;
    }

    @Override
    public void enqueueAC() {
        System.out.println("enqueueAC method implementation");
//        planes.addPlane();
    }

    @Override
    public void dequeueAC() {
        System.out.println("dequeueAC method implementation");
    }


}
