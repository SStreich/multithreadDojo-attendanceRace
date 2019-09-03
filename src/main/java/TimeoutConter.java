class TimeoutConter {
    private static int value = 0;

    synchronized void increment() {
        value += 1;
    }

     int getValue() {
        return value;
    }
}
