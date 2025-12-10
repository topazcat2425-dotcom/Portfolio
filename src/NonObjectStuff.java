import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Literally just a catch all for anything that I need.
 *
 * @author Trevor Baroni
 *
 */
public final class NonObjectStuff {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private NonObjectStuff() {
    }

    /**
     * different boolean array.
     */
    private static void proofOfConcept() {

        int choice = 53;

        if (choice / 32 == 1) {
            System.out.println("First is true!");
            choice -= 32;
        } else {
            System.out.println("First is not true.");
        }

        if (choice / 16 == 1) {
            System.out.println("Second is true!");
            choice -= 16;
        } else {
            System.out.println("Second is not true.");
        }

        if (choice / 8 == 1) {
            System.out.println("Third is true!");
            choice -= 8;
        } else {
            System.out.println("Third is not true.");
        }

        if (choice / 4 == 1) {
            System.out.println("Fourth is true!");
            choice -= 4;
        } else {
            System.out.println("Fourth is not true.");
        }

        if (choice / 2 == 1) {
            System.out.println("Fifth is true!");
            choice -= 2;
        } else {
            System.out.println("Fifth is not true.");
        }

        if (choice == 1) {
            System.out.println("Sixth is true!");
            choice -= 1;
        } else {
            System.out.println("Sixth is not true.");
        }
    }

    /**
     *
     * Creates and returns a {@code Map<String, String>} of the implementation
     * under test type with the given entries.
     *
     * @param args
     *            the (key, value) pairs for the map
     * @return the constructed map
     * @requires <pre>
     * [args.length is even]  and
     * [the 'key' entries in args are unique]
     * </pre>
     * @ensures createFromArgsTest = [pairs in args]
     */
    public static CoolBool createFromArgsTest(int len, String... args) {
        CoolBool arr = new CoolBool1(len);
        for (int i = 0; i < args.length; i += 2) {
            if (Boolean.parseBoolean(args[i])) {
                arr.setTrue(i);
            }
        }
        return arr;
    }

    /**
     *
     * Creates and returns a {@code Map<String, String>} of the implementation
     * under test type with the given entries.
     *
     * @param args
     *            the (key, value) pairs for the map
     * @return the constructed map
     * @requires <pre>
     * [args.length is even]  and
     * [the 'key' entries in args are unique]
     * </pre>
     * @ensures createFromArgsRef = [pairs in args]
     */
    public static boolean[] createFromArgsRef(int len, String... args) {
        boolean[] arr = new boolean[len];
        for (int i = 0; i < args.length; i += 2) {
            if (Boolean.parseBoolean(args[i])) {
                arr[i] = true;
            } else {
                arr[i] = false;
            }
        }
        return arr;
    }

    /**
     * Asks checks a y/n prompt.
     *
     * @param yesno
     *            the name of the file to be checked
     *
     * @requires yesno is not null.
     *
     * @return false if no.
     */
    public static boolean confirmation(String yesno) {
        assert yesno != null : "Violation of requires yesno is not null";
        String opinion = yesno.toLowerCase().trim();
        boolean opinionBool = true;

        // if the string contains n, we just assume its no. Otherwise its yes.
        if (opinion.contains("n")) {
            opinionBool = false;
        }

        return (opinionBool);
    }

    /**
     *
     * Assignment requirements.
     *
     * @throws IOException
     */
    public static void useCase1(CoolBool c) throws IOException {

        BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.println("\nAre AI smart? (y/n)");
        if (confirmation(in.readLine())) {
            c.setTrue(0);
        }
        System.out.println(
                "\nCan this be used to pass user input to other methods? (y/n)");
        if (confirmation(in.readLine())) {
            c.setTrue(1);
        }
        System.out.println("\nIs this a valid use case? (y/n)");
        in.readLine();
        c.setTrue(2);

        System.out.println("\nIs it bad that it's not dynamic? (y/n)");
        if (confirmation(in.readLine())) {
            c.setTrue(3);
        }

        System.out.println(
                "\nIs it because I didn't want to work with some slimy "
                        + "ArrayList under the hood? (y/n)");
        if (confirmation(in.readLine())) {
            c.setTrue(4);
        }

        System.out.println("\nAre you doing okay? (y/n)");
        if (confirmation(in.readLine())) {
            c.setTrue(5);
        }

        in.close();
    }

    /**
     *
     * Assignment requirements.
     *
     * @throws IOException
     */
    public static void useCase1AndAHalf(CoolBool c) {

        if (c.report(6)) {
            System.out.println("good to know you're doing good.");
        } else {
            System.out.println("I'm sorry to hear that.\n");
        }

        if (c.report(2)) {
            System.out.println(Arrays.toString(c.toArray()));
            System.out
                    .println("\"wait didn't I say no to the third question\"");
            System.out.println(
                    "is what you might be thinking, you see, I don't care. "
                            + "It's VALID!");
        }
    }

    /**
     *
     * Assignment requirements.
     *
     * @throws IOException
     */
    public static int useCase2(CoolBool c) {
        int number = 0;
        for (int i = 0; i < c.length(); i++) {
            if (c.report(i)) {
                number += Math.pow(2, i);
            }
        }

        return number;

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        int questionNum = 6;

        CoolBool c = new CoolBool3(questionNum);

        /*
         * it can store user input to be passed to other functions!
         */
        useCase1(c);
        useCase1AndAHalf(c);

        /*
         * it can be used to store numbers with bits using booleans!
         */
        System.out.println("------------------------------------------------");
        System.out.println("a second use case:");
        System.out.println(useCase2(c));

        // btw useCase2 isn't *technically* correct, but you get the idea right?

    }
}
