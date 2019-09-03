import java.util.Random;

public class App {

    public static void main(String[] args) {
        String[] names = {"JOSEF FRITZL", "CAAARL", "CHE GUEVARA", "MANSON", "KARADICZ", "ADOLF", "PAPJESZ", "TED BUNDY", "TITO", "POL POT"};

        Thread teacher = new Person("STALIN", true);
        teacher.start();
        for (int i = 0; i < 10; i++) {
            new Person(names[i], false).start();
        }
    }
}
