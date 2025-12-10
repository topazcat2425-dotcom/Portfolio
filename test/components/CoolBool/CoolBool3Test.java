package components.CoolBool;

/**
 * Customized JUnit test fixture for {@code CoolBool}.
 */
public class CoolBool3Test extends CoolBoolTest {

    @Override
    protected final CoolBool constructorTest() {
        return new CoolBool3();

    }

    @Override
    protected final CoolBool constructorTest(int i) {
        return new CoolBool3(i);
    }

    @Override
    protected final CoolBool constructorTest(String s) {
        return new CoolBool3(s);
    }

    @Override
    protected final boolean[] constructorRef() {
        return new boolean[0];
    }

    @Override
    protected final boolean[] constructorRef(int i) {
        boolean[] sendIt = new boolean[i];
        for (int j = 0; j < i; j++) {
            sendIt[j] = false;
        }
        return sendIt;
    }

    @Override
    protected final boolean[] constructorRef(String s) {
        int i = Integer.parseInt(s);
        boolean[] sendIt = new boolean[i];
        for (int j = 0; j < i; j++) {
            sendIt[j] = false;
        }
        return sendIt;
    }

}
