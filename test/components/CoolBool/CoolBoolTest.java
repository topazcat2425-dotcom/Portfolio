package components.CoolBool;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

/**
 * JUnit test fixture for {@code CoolBool}'s constructors, kernel and secondary
 * methods.
 *
 * @author Trevor Baroni
 */
public abstract class CoolBoolTest {

    /**
     * Invokes the appropriate {@code CoolBool} constructor for the
     * implementation under test and returns the result.
     *
     * @return the new array
     * @ensures constructorTest = 0
     */
    protected abstract CoolBool constructorTest();

    /**
     * Invokes the appropriate {@code CoolBool} constructor for the reference
     * implementation and returns the result.
     *
     * @param i
     *            {@code String} to initialize from
     * @return the new array
     */
    protected abstract CoolBool constructorTest(int i);

    /**
     * Invokes the appropriate {@code CoolBool} constructor for the reference
     * implementation and returns the result.
     *
     * @param s
     *            {@code String} to initialize from
     * @return the new array
     */
    protected abstract CoolBool constructorTest(String s);

    /**
     * Invokes the appropriate {@code boolean[]} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new array
     * @ensures constructorRef = 0
     */
    protected abstract boolean[] constructorRef();

    /**
     * Invokes the appropriate {@code boolean[]} constructor for the reference
     * implementation and returns the result.
     *
     * @param i
     *            {@code int} to initialize from
     * @return the new array
     */
    protected abstract boolean[] constructorRef(int i);

    /**
     * Invokes the appropriate {@code boolean[]} constructor for the reference
     * implementation and returns the result.
     *
     * @param s
     *            {@code String} to initialize from
     * @return the new array
     */
    protected abstract boolean[] constructorRef(String s);

    /**
     *
     * Creates and returns a {@code CoolBool} of the implementation under test
     * type with the given entries.
     *
     * @param len
     *            the length of the CoolBool
     * @param args
     *            the booleans as strings
     * @return the constructed array
     */
    public CoolBool createFromArgsTest(int len, String... args) {
        CoolBool arr = this.constructorTest(len);
        for (int i = 0; i < args.length; i++) {
            if (Boolean.parseBoolean(args[i])) {
                arr.setTrue(i);
            }
        }
        return arr;
    }

    /**
     *
     * Creates and returns a {@code boolean[]} of the implementation under test
     * type with the given entries.
     *
     * @param len
     *            the length of the array
     * @param args
     *            the booleans as strings
     * @return the constructed array
     */
    public boolean[] createFromArgsRef(int len, String... args) {
        boolean[] arr = this.constructorRef(len);
        for (int i = 0; i < args.length; i++) {
            if (Boolean.parseBoolean(args[i])) {
                arr[i] = true;
            } else {
                arr[i] = false;
            }
        }
        return arr;
    }

    /**
     * Tests the no-argument constructor.
     */
    @Test
    public void noArgConstructorTest() {

        CoolBool cb = this.constructorTest();
        boolean[] cbExpected = this.constructorRef();

        assertArrayEquals(cb.toArray(), cbExpected);
    }

    @Test
    public final void intArgConstructorZero() {
        CoolBool cb = this.constructorTest(0);
        boolean[] cbExpected = this.constructorRef(0);

        assertArrayEquals(cb.toArray(), cbExpected);
    }

    @Test
    public final void intArgConstructorOne() {
        CoolBool cb = this.constructorTest(1);
        boolean[] cbExpected = this.constructorRef(1);

        assertArrayEquals(cb.toArray(), cbExpected);
    }

    @Test
    public final void intArgConstructorMany() {
        CoolBool cb = this.constructorTest(1234);
        boolean[] cbExpected = this.constructorRef(1234);

        assertArrayEquals(cb.toArray(), cbExpected);
    }

    // Java can't handle arrays this big!
    // @Test
    // public final void intArgConstructorMax() {
    //     CoolBool cb = this.constructorTest(2147483647);
    //     boolean[] cbExpected = this.constructorRef(2147483647);

    //     assertArrayEquals(cb.toArray(), cbExpected);
    // }

    @Test
    public final void stringArgConstructorZero() {
        CoolBool cb = this.constructorTest("0");
        boolean[] cbExpected = this.constructorRef("0");

        System.out.println(cb.toString());
        System.out.println(Arrays.toString(cbExpected));

        assertArrayEquals(cb.toArray(), cbExpected);
    }

    @Test
    public final void stringArgConstructorOne() {
        CoolBool cb = this.constructorTest("1");
        boolean[] cbExpected = this.constructorRef("1");

        System.out.println(cb.toString());
        System.out.println(Arrays.toString(cbExpected));

        assertArrayEquals(cb.toArray(), cbExpected);
    }

    @Test
    public final void stringArgConstructorMany() {
        CoolBool cb = this.constructorTest("1234");
        boolean[] cbExpected = this.constructorRef("1234");

        assertArrayEquals(cb.toArray(), cbExpected);
    }

    // same problem :/
    // @Test
    // public final void stringArgConstructorMax() {
    //     CoolBool cb = this.constructorTest("2,147,483,647");
    //     boolean[] cbExpected = this.constructorRef("2,147,483,647");

    //     assertArrayEquals(cb.toArray(), cbExpected);
    // }

    @Test
    public final void testWithSomeStuff() {
        CoolBool cb = this.createFromArgsTest(3, "true", "false", "false");
        boolean[] cbExpected = this.createFromArgsRef(3, "true", "false",
                "false");

        assertArrayEquals(cb.toArray(), cbExpected);
    }

    /**
     * make sure the test works lmao.
     */
    @Test
    public final void testTest() {

        boolean[] cb = { true, true, false };
        boolean[] cbExpected = { true, true, false };

        assertArrayEquals(cb, cbExpected);
    }

    /*
     * test the kernel methods
     */
    @Test
    public final void testSetTrue() {
        CoolBool cb = this.createFromArgsTest(4, "true", "false", "false",
                "false");
        boolean[] cbExpected = this.createFromArgsRef(4, "true", "false",
                "false", "true");

        cb.setTrue(cb.length() - 1);

        assertArrayEquals(cb.toArray(), cbExpected);
    }

    @Test
    public final void testSetTrue2() {
        CoolBool cb = this.createFromArgsTest(8, "true", "false", "false",
                "false", "false", "false", "false", "false");
        boolean[] cbExpected = this.createFromArgsRef(8, "true", "false",
                "false", "false", "false", "false", "false", "true");

        cb.setTrue(cb.length() - 1);

        assertArrayEquals(cb.toArray(), cbExpected);
    }

    @Test
    public final void testSetFalse() {
        CoolBool cb = this.createFromArgsTest(4, "true", "false", "false",
                "true");
        boolean[] cbExpected = this.createFromArgsRef(4, "true", "false",
                "false", "false");

        cb.setFalse(cb.length() - 1);

        assertArrayEquals(cb.toArray(), cbExpected);
    }

    @Test
    public final void testSetFalse2() {
        CoolBool cb = this.createFromArgsTest(8, "true", "false", "false",
                "false", "false", "false", "false", "true");
        boolean[] cbExpected = this.createFromArgsRef(8, "true", "false",
                "false", "false", "false", "false", "false", "false");

        cb.setFalse(cb.length() - 1);

        assertArrayEquals(cb.toArray(), cbExpected);
    }

    @Test
    public final void testLength() {
        CoolBool cb = this.createFromArgsTest(4, "true", "false", "false",
                "true");
        boolean[] cbExpected = this.createFromArgsRef(4, "true", "false",
                "false", "false");

        assertEquals(cb.length(), cbExpected.length);
    }

    /*
     * ok time for secondary methods
     */

    @Test
    public final void testToArray() {
        CoolBool cb = this.createFromArgsTest(8, "true", "false", "false",
                "false", "false", "false", "false", "false");
        boolean[] cbExpected = this.createFromArgsRef(8, "true", "false",
                "false", "false", "false", "false", "false", "false");

        // uhh... kinda redundant... but sure

        assertArrayEquals(cb.toArray(), cbExpected);
    }

    @Test
    public final void testToString() {
        CoolBool cb = this.createFromArgsTest(8, "true", "false", "false",
                "false", "false", "false", "false", "false");

        // why is my toString like this? I forgot!
        assertEquals(cb.toString(), "10000000");
    }

    @Test
    public final void testBoolFlip() {
        CoolBool cb = this.createFromArgsTest(8, "true", "false", "false",
                "false", "true", "false", "false", "true");
        boolean[] cbExpected = this.createFromArgsRef(8, "false", "true",
                "true", "true", "false", "true", "true", "false");

        cb.boolflip();

        assertArrayEquals(cb.toArray(), cbExpected);
    }

    @Test
    public final void testNumTrue() {
        CoolBool cb = this.createFromArgsTest(8, "true", "false", "false",
                "false", "true", "false", "false", "true");

        assertEquals(cb.numTrue(), 3);
    }

    @Test
    public final void testEquals() {
        CoolBool cb = this.createFromArgsTest(8, "true", "false", "false",
                "false", "true", "false", "false", "true");
        CoolBool cbExpected = this.createFromArgsTest(8, "true", "false",
                "false", "false", "true", "false", "false", "true");

        assertTrue(cb.equals(cbExpected));
    }

    // I don't need to test hashcode or equals right?
}
