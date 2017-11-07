package scratch;

public enum AC_Type {
    PASSENGER(0),
    CARGO(1);

    private int priority;

    AC_Type(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }


    @Override
    public String toString() {
        return "AC_Type{" +
                "priority=" + priority +
                '}';
    }
}
