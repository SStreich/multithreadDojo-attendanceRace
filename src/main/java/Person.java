import java.util.Random;

public class Person extends Thread {
    private static volatile Boolean isArrived = true;
    private static final TimeoutConter timeout = new TimeoutConter();
    private final boolean isTeacher;

    Person(String name, boolean isTeacher) {
        super(name);
        this.isTeacher = isTeacher;
    }

    @Override
    public void run() {
            try {
                if(isTeacher) {
                    Thread.sleep(new Random().nextInt(5));
                }
            } catch (InterruptedException ex) {
                System.out.println("Interrupted");
            } finally {
                synchronized (timeout) {
                    timeout.increment();
                    if(isTeacher) isArrived = false;
                    printMessage();
                    timeout.notify();
                }
            }
        }

        private void printMessage() {
            String message;
            if(isTeacher) {
                message = "ARRIVED TEACHER";
            } else if (isArrived) {
                message = "ARRIVED STUDENT";
            } else  {
                message = "KICKED OUT STUDENT";
            }
            System.out.println(message + "{name=" + this.getName() + " timeout=" + timeout.getValue() + " isArrived=" + isArrived + "}");
        }

    }
