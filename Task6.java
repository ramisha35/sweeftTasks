import java.util.LinkedList;

class KeyValuePair<K, V> {
    private K key;
    private V value;

    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

class CustomHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private LinkedList<KeyValuePair<K, V>>[] buckets;
    private int size;

    public CustomHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public CustomHashMap(int capacity) {
        buckets = new LinkedList[capacity];
        size = 0;
    }

    private int hash(K key) {
        return key.hashCode() % buckets.length;
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        LinkedList<KeyValuePair<K, V>> bucket = buckets[index];
        for (KeyValuePair<K, V> pair : bucket) {
            if (pair.getKey().equals(key)) {
                pair.setValue(value); // Update value if key already exists
                return;
            }
        }
        bucket.add(new KeyValuePair<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        LinkedList<KeyValuePair<K, V>> bucket = buckets[index];
        if (bucket != null) {
            for (KeyValuePair<K, V> pair : bucket) {
                if (pair.getKey().equals(key)) {
                    return pair.getValue();
                }
            }
        }
        return null; // Key not found
    }

    public void remove(K key) {
        int index = hash(key);
        LinkedList<KeyValuePair<K, V>> bucket = buckets[index];
        if (bucket != null) {
            for (KeyValuePair<K, V> pair : bucket) {
                if (pair.getKey().equals(key)) {
                    bucket.remove(pair);
                    size--;
                    return;
                }
            }
        }
    }

    public int size() {
        return size;
    }
}



public class Task6<T> {
    private final CustomHashMap<T, Integer> hashMap;
    private int size = 0;
    public Task6(){
        hashMap = new CustomHashMap<>();
    }

    public Task6(int capacity) {
        hashMap = new CustomHashMap<>(capacity);
    }

    public void add(T el) {
        if(hashMap.get(el) != null){
            hashMap.put(el, hashMap.get(el)+1);
            size++;
            return;
        }
        hashMap.put(el, 1);
        size++;
    }

    public boolean contains(T el){
        if(hashMap.get(el) == null) return false;
        if(hashMap.get(el) <= 0) return false;

        return true;
    }

    public void remove(T el){
        if(contains(el)){
            hashMap.put(el, hashMap.get(el)-1);
            size--;
        }
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Task6<String> hashMap = new Task6<>();
        hashMap.add("one");
        hashMap.add("two");
        hashMap.add("three");

        System.out.println("Size: " + hashMap.size());
        System.out.println("Contains 'two': " + hashMap.contains("two"));

        hashMap.remove("two");
        System.out.println("Size after removal: " + hashMap.size());
        System.out.println("Contains 'two' after removal: " + hashMap.contains("two"));
    }
}
