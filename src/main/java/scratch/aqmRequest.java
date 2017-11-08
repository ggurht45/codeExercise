package scratch;
enum REQUEST_TYPE{
    BOOT,ENQUEUE,DEQUEUE, QUEUE_STATE;
}
public class aqmRequest {

    private REQUEST_TYPE request_type;
    private AC acDataObj;

    public aqmRequest(REQUEST_TYPE request_type, AC acDataObj) {
        this.request_type = request_type;
        this.acDataObj = acDataObj;
    }

    public REQUEST_TYPE getRequest_type() {
        return request_type;
    }

    public void setRequest_type(REQUEST_TYPE request_type) {
        this.request_type = request_type;
    }

    public AC getAcDataObj() {
        return acDataObj;
    }

    public void setAcDataObj(AC acDataObj) {
        this.acDataObj = acDataObj;
    }
}
