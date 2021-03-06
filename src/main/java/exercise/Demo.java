package exercise;


public class Demo {
    static SystemOne sysOne = new SystemOne();

    //process different requests
    static void aqmRequestProcess(aqmRequest r){
        switch (r.getRequest_type()){
            case BOOT:
                sysOne.boot();
                break;
            case ENQUEUE:
                sysOne.enqueueAC(r.getAcDataObj());
                break;
            case DEQUEUE:
                sysOne.dequeueAC();
                break;
            case QUEUE_STATE:
                System.out.println(sysOne.queueState());
                break;
        }
    }

    //create system one object, run three methods on it
    public static void main(String[] args){
        aqmRequest br = new aqmRequest(REQUEST_TYPE.BOOT, null);
        aqmRequestProcess(br);

        //4 different types of combinations possible.
        aqmRequest a1 = new aqmRequest(REQUEST_TYPE.ENQUEUE, new AC(AC_Type.PASSENGER, AC_Size.LARGE));
        aqmRequestProcess(a1);

        aqmRequest a2 = new aqmRequest(REQUEST_TYPE.ENQUEUE, new AC(AC_Type.PASSENGER, AC_Size.SMALL));
        aqmRequestProcess(a2);

        aqmRequest a3 = new aqmRequest(REQUEST_TYPE.ENQUEUE, new AC(AC_Type.CARGO, AC_Size.LARGE));
        aqmRequestProcess(a3);

        aqmRequest a4 = new aqmRequest(REQUEST_TYPE.ENQUEUE, new AC(AC_Type.CARGO, AC_Size.SMALL));
        aqmRequestProcess(a4);

        aqmRequest a5 = new aqmRequest(REQUEST_TYPE.ENQUEUE, new AC(AC_Type.PASSENGER, AC_Size.LARGE));
        aqmRequestProcess(a5);


        //should remove automatically remove in order of precedence
        aqmRequestProcess(new aqmRequest(REQUEST_TYPE.DEQUEUE,null));
        aqmRequestProcess(new aqmRequest(REQUEST_TYPE.QUEUE_STATE,null));
        aqmRequestProcess(new aqmRequest(REQUEST_TYPE.DEQUEUE,null));
        aqmRequestProcess(new aqmRequest(REQUEST_TYPE.QUEUE_STATE,null));
        aqmRequestProcess(new aqmRequest(REQUEST_TYPE.DEQUEUE,null));
        aqmRequestProcess(new aqmRequest(REQUEST_TYPE.QUEUE_STATE,null));
        aqmRequestProcess(new aqmRequest(REQUEST_TYPE.DEQUEUE,null));
        aqmRequestProcess(new aqmRequest(REQUEST_TYPE.QUEUE_STATE,null));


    }


}

