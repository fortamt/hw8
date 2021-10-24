public class MyQueue<E> {

    int size = 0;

    Node<E> first;
    Node<E> last;

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

    public int size(){
        return size;
    }

    public E peek(){
        final Node<E> f = first;
        return (f == null) ? null : f.item;
    }



    public E poll(){
        E result =peek();
        remove(0);
        return result;
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
                result.append(getNode(i).item);
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


class MyQueueTest{
    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<>();
        queue.add("one");
        queue.add("two");
        queue.add("three");
        queue.add("four");
        queue.add("five");
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);

    }
}