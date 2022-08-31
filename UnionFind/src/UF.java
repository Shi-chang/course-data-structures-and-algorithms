/**
 * The union find interface.
 */

public interface UF {
    /**
     * Gets the size of the set.
     *
     * @return the size of the set
     */
    int getSize();

    /**
     * Examines if two elements are connected.
     *
     * @param p the first element
     * @param q the second element
     * @return true if two elements are connected, false otherwise
     */
    boolean isConnected(int p, int q);

    /**
     * Unions the sets that the two elements belong to.
     *
     * @param p the first element
     * @param q the second element
     */
    void union(int p, int q);
}
