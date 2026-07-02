package library.model;

public class Pair<K, V> {

    private K key;
    private V value;

    public Pair() {
    }

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    // Getter
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    // Setter
    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }

    // Đảo key và value
    public static <K, V> Pair<V, K> swap(Pair<K, V> pair) {
        return new Pair<>(pair.getValue(), pair.getKey());
    }

    // So sánh theo value
    public static <K, V extends Comparable<V>>
    boolean comparePairs(Pair<K, V> p1, Pair<K, V> p2) {

        return p1.getValue().compareTo(p2.getValue()) == 0;
    }
}