package scratch;

public class AC {

    AC_Type type;
    AC_Size size;

    public AC(AC_Type type, AC_Size size) {
        this.type = type;
        this.size = size;
    }

    public AC_Type getType() {
        return type;
    }

    public void setType(AC_Type type) {
        this.type = type;
    }

    public AC_Size getSize() {
        return size;
    }

    public void setSize(AC_Size size) {
        this.size = size;
    }
}


