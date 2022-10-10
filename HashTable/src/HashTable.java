import java.util.TreeMap;

/**
 * This class is an implementation of a hash table structure.
 *
 * @param <K> the generic type of the key
 * @param <V> the generic type of the value
 */
public class HashTable<K, V> {
    private static final int UPPER_TOL = 10;
    private static final int LOWER_TOL = 2;
    private static final int initCapacity = 7;

    private TreeMap<K, V>[] hashTable;
    private int M;
    private int size;

    /**
     * Constructor for the class.
     *
     * @param M
     */
    public HashTable(int M) {
        this.M = M;
        size = 0;
        hashTable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }

    /**
     * No-argument constructor for the class.
     */
    public HashTable() {
        this(initCapacity);
    }

    /**
     * Creates a hash code.
     *
     * @param key the key
     * @return a hash code
     */
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    /**
     * Gets the size of the hash table.
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Adds a key, value pair to the hash table.
     *
     * @param key   the key of the pair
     * @param value the value of the pair
     */
    public void add(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;

            if (size >= UPPER_TOL * M) {
                resize(2 * M);
            }
        }
    }

    /**
     * Removes an element with the specified key.
     *
     * @param key the key of the element to be removed
     * @return the value of the removed element
     */
    public V remove(K key) {
        TreeMap<K, V> map = hashTable[hash(key)];
        V ret = null;
        if (map.containsKey(key)) {
            ret = map.remove(key);
            size--;

            if (size < LOWER_TOL * M && M / 2 > initCapacity) {
                resize(M / 2);
            }
        }
        return ret;
    }

    /**
     * Sets the value of an element with the specified key.
     *
     * @param key   the key of the element
     * @param value the new value of the element
     */
    public void set(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        map.put(key, value);
    }

    /**
     * Checks if the hash table contains an element with the specified key.
     *
     * @param key the specified key
     * @return true if the hash table contains an element with the specified key, false otherwise
     */
    public boolean contains(K key) {
        return hashTable[hash(key)].containsKey(key);
    }

    /**
     * Gets the value of the element with the specified key.
     *
     * @param key the specified key
     * @return the value of the element with the specified key
     */
    public V get(K key) {
        return hashTable[hash(key)].get(key);
    }

    /**
     * Resizes the tree map when it reaches full capacity.
     *
     * @param newM the new capacity of the tree map
     */
    private void resize(int newM) {
        TreeMap<K, V>[] newHashTable = new TreeMap<>[newM];
        for (int i = 0; i < newM; i++) {
            newHashTable[i] = new TreeMap<>();
        }

        int oldM = M;
        this.M = newM;
        for (int i = 0; i < oldM; i++) {
            TreeMap<K, V> map = hashTable[i];
            for (K key : map.keySet()) {
                newHashTable[hash(key)].put(key, map.get(key));
            }
        }

        this.hashTable = newHashTable;
    }
}
