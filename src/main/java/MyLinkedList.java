public class MyLinkedList<E> {
    int size = 0;

    Node<E> first;

    Node<E> last;

    public MyLinkedList(){
    }

    void add(E e){
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e , null);
        last = newNode;
        if(l == null){
            first = newNode;
        } else{
            l.next=newNode;
        }
        size++;
    }

    void remove(int index){
        final Node<E> next = getNode(index).next;
        final Node<E> prev = getNode(index).prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            getNode(index).prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
        }
        size--;
    }

    public int size(){
        return size;
    }

    void clear(){
        for(Node<E> x = first; x != null; ){
            Node<E> next =x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size=0;
    }

    public E get(int index){
        Node<E> x = first;
        for(int i =0; i < index; i++){
            x=x.next;
        }
        return x.item;
    }

    Node<E> getNode(int index){
        Node<E> x = first;
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
                result.append(get(i));
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

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}

class MyLinkedListTest{
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        System.out.println(list.size());
        list.remove(2);
        System.out.println(list);
        System.out.println(list.size());
        list.clear();
        System.out.println(list);
        System.out.println(list.size());

    }
}
