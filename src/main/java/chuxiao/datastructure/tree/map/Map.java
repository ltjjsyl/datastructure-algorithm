package chuxiao.datastructure.tree.map;

public interface Map<K, V> {

    int getSize();

    boolean isEmpty();

    void add(K key, V value);

    V get(K key);

    void set(K key, V value);

    boolean containsKey(K key);

    V remove(K key);
}
