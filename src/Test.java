import java.util.Arrays;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class Test {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Test() {
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
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {

        CoolBool c = new CoolBool1(32);

        c.setTrue(3);
        c.setTrue(0);
        c.setTrue(6);

        c.setTrue(31);

        c.setTrue(30);

        c.setTrue(9);
        c.setTrue(7);

        System.out.println(Arrays.toString(c.toArray()));

        if (c.report(0)) {
            System.out.println("GENIUS!");
        }

        c.setFalse(3);
        c.setFalse(7);
        c.setFalse(0);

        System.out.println(Arrays.toString(c.toArray()));

        if (c.report(9)) {
            System.out.println("you are the smartest man alive");
        }

        c.boolflip();

        System.out.println(Arrays.toString(c.toArray()));

        for (boolean i : c) {
            System.out.println(i);
        }

        CoolBool d = c.newInstance();
        d.transferFrom(c);
        System.out.println(Arrays.toString(c.toArray()));
        System.out.println(Arrays.toString(d.toArray()));
    }
}
