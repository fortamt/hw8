import java.util.LinkedList;

public class MyHashMap<K, V> {

    Node<K, V> first;
    Node<K, V> current;
    private int size = 0;

    public void put(K key, V value) {
        final Node<K, V> l = current;
        final Node<K, V> newNode = new Node<>(key, value, null);
        if(size == 0){
            first = newNode;
            current = newNode;
        } else {
            if(!current.key.equals(key)) {
                current.next = newNode;
                current = newNode;
            }
        }
        size++;
    }

    public void remove(K key){
        int counter = 0;
        for (Node<K, V> x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
                if(counter <= 0){
                    Node<K,V> newFirst = getNode(counter+1);
                    first = newFirst;
                    size--;
                    return;
                } else{
                    Node<K,V> prev = getNode(counter-1);
                    prev.next = x.next;
                    size--;
                    return;
                }
            }
            counter++;
        }
    }

    public void clear(){
        first = null;
        current = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public V get(K key) {
        V value = null;
        for (int i = 0; i < size; i++) {
            if(key.equals(getNode(i).key)){
                value = getNode(i).value;
            }
        }
        return value;
    }

    Node<K, V> getNode(int index){
        Node<K, V> x = first;
        for(int i =0; i < index; i++){
            x=x.next;
        }
        return x;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("[");
        if(this.size <= 0){
            result.append("]");
        } else {
            for(int i = 0; i < size; i++){
                result.append(getNode(i).key + "=" + getNode(i).value);
                if(i != size-1){
                    result.append(", ");
                } else {
                    result.append("]");
                    return result.toString();
                }
            }
        }
        return result.toString();
    }


    private static class Node<K, V>{
        final K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey(){ return key; }
        public final V getValue(){ return value; }
        public final String toString() { return key + "=" + value; }
    }


}

class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("Васька", 5);
        map.put("Мурзик", 8);
        map.put("Рыжик", 12);
        map.put("Барсик", 5);
        System.out.println(map.get("Васька"));
        System.out.println(map.get("Мурзик"));
        System.out.println(map.get("Рыжик"));
        System.out.println(map);
        map.remove("Мурзик");
        System.out.println(map);
        map.remove("Барсик");
        System.out.println(map);
        System.out.println(map.size());
        map.clear();
        System.out.println(map);
        System.out.println(map.size());

    }
}
