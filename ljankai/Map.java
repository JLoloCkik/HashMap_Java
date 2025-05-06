package ljankai;

public interface Map <K, V> {
    boolean add(K key, V value);
    V remove(K key);
    V get(K key);
}
