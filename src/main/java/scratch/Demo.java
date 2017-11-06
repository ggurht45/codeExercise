package scratch;


public class Demo {

    //create system one object, run three methods on it
    public static void main(String[] args){

        SystemOne sysOne = new SystemOne();

        sysOne.boot();
        sysOne.enqueueAC();
        sysOne.dequeueAC();
    }


}

