/**
 *
 * @author Trevor Baroni
 *
 */
public interface CoolBoolKernel
        extends Standard<CoolBoolSecondary>, Iterable<Byte> {

    /**
     * @param pos
     */
    void setTrue(boolean pos);

    /**
     * @param pos
     *
     * @return removed element
     */
    boolean setFalse(int pos);

    /**
     * @param pos
     *
     * @return reported element
     */
    boolean report(int pos);

}
