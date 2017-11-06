package scratch;

public class SystemOne implements AQSystem {

//    private Map<String, >


    @Override
    public boolean boot() {
        System.out.println("boot method implementation");
        return false;
    }

    @Override
    public void enqueueAC() {
        System.out.println("enqueueAC method implementation");
    }

    @Override
    public void dequeueAC() {
        System.out.println("dequeueAC method implementation");
    }


}
