
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



    }
}
