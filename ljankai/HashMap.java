package ljankai;

import java.util.ArrayList;

class HashMap<K, V> implements Map<K, V> {
    private final double loadFactor;
    private long size;
    ArrayList<Entry<K, V>>[] buckets;

    @SuppressWarnings("unchecked")
    public HashMap(int initialCapacity, double loadFactor) {
        this.loadFactor = loadFactor;
        buckets = new ArrayList[initialCapacity];
    }

    public HashMap() {
        this(10, 0.75);
    }

    @Override
    public boolean add(K key, V value) {
        if (size >= buckets.length * loadFactor) {
            rehash();
        }

        int index = CalculateHashCode(key);
        if (buckets[index] == null) {
            buckets[index] = new ArrayList<>();
        }
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                return false;
            }
        }

        buckets[index].add(new Entry<K, V>(key, value));
        size++;
        return true;
    }

    @Override
    public V remove(K key) {
        int index = CalculateHashCode(key);
        if (buckets[index] == null) {
            return null;
        }
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                buckets[index].remove(entry);
                size--;
                return entry.value;
            }
        }
        return null;
    }

    @Override
    public V get(K key) {
        int index = CalculateHashCode(key);

        if (buckets[index] == null) {
            return null;
        }

        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private void rehash() {
        int newCapacity = (int) (buckets.length * 1.5);
        ArrayList<Entry<K,V>>[] newBuckets = new ArrayList[newCapacity];

        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                for (Entry<K, V> entry : buckets[i]) {
                    int newIndex = Math.abs(entry.key.hashCode()) % newCapacity;
                    if (newBuckets[newIndex] == null) {
                        newBuckets[newIndex] = new ArrayList<>();
                    }
                    newBuckets[newIndex].add(entry);
                }
            }
        }
        buckets = newBuckets;
    }

    private int CalculateHashCode(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public static class Entry<K, V> {
        public final K key;
        public final V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}


// class ljankai.Map {
//  public bool add(key, value){}
//  public value remove(key){}
//  public value get(key){}
//  public iterator(){}
// }


// int hashCode() // memoriacim
// MyString key = "kulcs"
// ljankai.Map map = new ljankai.Map()
// map.add(key, "ertek")
// map.get("kulcs") <- nem ad vissza semmit