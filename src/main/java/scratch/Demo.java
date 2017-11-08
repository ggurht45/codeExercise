package scratch;


public class Demo {

    void aqmRequestProcess(aqmRequest r){
        //process request.
        //http request. url, rest api, and json data for
    }

    //create system one object, run three methods on it
    public static void main(String[] args){
        SystemOne sysOne = new SystemOne();
        sysOne.boot();

        //4 different types of combinations possible.
        AC a1 = new AC(AC_Type.PASSENGER, AC_Size.LARGE);
        AC a2 = new AC(AC_Type.PASSENGER, AC_Size.SMALL);
        AC a3 = new AC(AC_Type.CARGO, AC_Size.LARGE);
        AC a4 = new AC(AC_Type.CARGO, AC_Size.SMALL);
        AC a5 = new AC(AC_Type.PASSENGER, AC_Size.LARGE);

        sysOne.enqueueAC(a1);
        sysOne.enqueueAC(a2);
        sysOne.enqueueAC(a3);
        sysOne.enqueueAC(a4);
        sysOne.enqueueAC(a5);
        System.out.println(sysOne.getCurrentQueueState());

        //should remove automatically remove in order of precedence
        sysOne.dequeueAC();
        System.out.println(sysOne.getCurrentQueueState());

    }


}

