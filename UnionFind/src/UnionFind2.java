/**
 * This class is the second version implementation of the UF interface. It is an improvement
 * from UnionFind1 in that it reduces the time complexity of union operation from O(h) to O(h).
 * At the beginning, every element is the parent of itself. Each union changes the parent array
 * by storing the index of the parent element in the position of its child element. For example,
 * parent = [0, 1, 2, 3, 4, 5] is the initial state. The union of the first and second elements
 * leads to parent = [0, 0, 1, 2, 3, 4, 5].
 */
public class UnionFind2 implements UF{
    private int[] parent;

    /**
     * Constructor.
     *
     * @param size the size of the disjoint sets.
     */
    public UnionFind2(int size){
        parent = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    /**
     * Gets the size of the disjoint sets.
     *
     * @return the size of the set
     */
    @Override
    public int getSize(){
        return parent.length;
    }

    /**
     * Finds the parent of the set that element p belongs to.
     * Time complexity = O(h), where h is the height of the tree.
     *
     * @param p the element
     * @return the id of the set that element p belongs to
     */
    private int find(int p){
        if(p < 0 || p > parent.length - 1){
            throw new IllegalArgumentException("Find failed. Invalid p.");
        }

        while(parent[p] != p){
            p = parent[p];
        }
        return p;
    }

    /**
     * Examines if two elements are connected.
     * Time complexity = O(h), where h is the height of the tree.
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
     * Time complexity = O(h), where h is the height of the tree.
     *
     * @param p the first element
     * @param q the second element
     */
    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot){
            return;
        }

        parent[pRoot] = qRoot;
    }
}
