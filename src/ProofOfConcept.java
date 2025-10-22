
/**
 * My booleans on integers idea works!!
 *
 * @author Trevor Baroni
 *
 */
public final class ProofOfConcept {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private ProofOfConcept() {
    }

    /**
     * Reads the "array" and reports what the first 6 values are
     *
     * @param choice
     */
    private static void boolReading(int choice) {

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
     * Sets the member of the array to true.
     *
     * @param pos
     *
     * @requires pos < 6
     *
     * @return num
     */
    public static int setTrue(int pos) {
        assert pos < 6 : "HEY! stop that";

        int val = 64;

        for (int i = 0; i < pos; i++) {
            val /= 2;
        }

        return val;

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {

        int arr = 0;

        arr += setTrue(5);
        arr += setTrue(2);
        arr += setTrue(1);

        System.out.println(arr);

        boolReading(arr);
    }
}
