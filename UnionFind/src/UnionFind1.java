/**
 * This class is the first version implementation of the UF interface. The set that an element
 * belongs to is stored in the id array. For example, id = [0, 0, 0, 0, 1, 1, 1, 1] indicates
 * that the first four elements belong to the first set, and the second four elements belong
 * to the second set.
 */
public class UnionFind1 implements UF{
    private int [] id;

    /**
     * Constructor.
     *
     * @param size the size of the disjoint sets.
     */
    public UnionFind1(int size){
        id = new int[size];

        for(int i = 0; i < id.length; i++){
            id[i] = i;
        }
    }

    /**
     * Gets the size of the set.
     *
     * @return the size of the disjoint sets
     */
    @Override
    public int getSize(){
        return id.length;
    }

    /**
     * Finds the id of the set that element p belongs to.
     * Time complexity = O(1)
     *
     * @param p the element
     * @return the id of the set that element p belongs to
     */
    private int find(int p){
        if(p < 0 || p > id.length - 1){
            throw new IllegalArgumentException("Find failed. Invalid p.");
        }
        return id[p];
    }

    /**
     * Examines if two elements are connected.
     * Time complexity = O(1)
     *
     * @param p the first element
     * @param q the second element
     * @return true if two elements are connected, false otherwise
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * Unions the sets that the two elements belong to.
     * Time complexity = O(n)
     *
     * @param p the first element
     * @param q the second element
     */
    @Override
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if(pID == qID){
            return;
        }

        for(int i = 0; i < id.length; i++){
            if(id[i] == pID){
                id[i] = qID;
            }
        }
    }
}
