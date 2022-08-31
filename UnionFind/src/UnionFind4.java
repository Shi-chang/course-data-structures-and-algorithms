/**
 * This class is an improvement of UnionFind2. When merging two sets, it considers the
 * height of the roots, and places the one with small height under the other
 * one in order to reduce the max height of the tree.
 */
public class UnionFind4 implements UF{
    private int[] parent;
    // rank[i] is the height of ith element.
    private int[] rank;

    /**
     * Constructor.
     *
     * @param size the size of the disjoint sets.
     */
    public UnionFind4(int size){
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
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
        // To reduce the height of the tree, make the root with a larger height the parent of the
        // other root.
        if(rank[pRoot] < rank[qRoot]){
            parent[pRoot] = qRoot;
        }else if(rank[pRoot] > rank[qRoot]){
            parent[qRoot] = pRoot;
        }else{
            parent[qRoot] = pRoot;
            rank[pRoot]++;
        }
    }
}
