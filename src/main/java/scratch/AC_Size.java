package scratch;

public enum AC_Size {
    LARGE(0),
    SMALL(1);

    private int priority;

    AC_Size(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "AC_Size{" +
                "priority=" + priority +
                '}';
    }
}
