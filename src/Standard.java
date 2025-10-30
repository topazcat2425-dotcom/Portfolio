/**
 *
 * @param T
 *            this does stuff.
 *
 * @author Trevor Baroni
 *
 */
public interface Standard<T> {

    /**
     * @param source
     *
     * @return the new CoolBool
     * @update clears source
     */
    CoolBool transferFrom(CoolBool source);

    /**
     * @return new instance of this
     */
    CoolBool newInstance();

    /**
     * @clears this
     */
    void clear();
}