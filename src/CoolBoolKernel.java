/**
 *
 * @author Trevor Baroni
 *
 */
public interface CoolBoolKernel
        extends Standard<CoolBoolSecondary>, Iterable<Byte> {

    /**
     * @param entry
     */
    void add(boolean entry);

    /**
     * @param pos
     *
     * @return removed element
     */
    boolean remove(int pos);

    /**
     * @param pos
     *
     * @return reported element
     */
    boolean report(int pos);

}
