import java.util.LinkedList;

public class MyStack<E> {

    int size = 0;
    Node<E> first;
    Node<E> last;

    public E push(E e){
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e , null);
        last = newNode;
        if(l == null){
            first = newNode;
        } else{
            l.next=newNode;
        }
        size++;
        return e;
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

    public E peek(){
        final Node<E> l = last;
        return (l == null) ? null : l.item;
    }

    public E pop(){
        E result = peek();
        unlinkLast();
        return result;
    }

    public int size(){ return size; }

    private void unlinkLast() {
        final Node<E> prev = last.prev;
        last.item = null;
        last.prev = null; // help GC
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
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

class MyStackTest{
    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack();
        myStack.push("one");
        myStack.push("two");
        myStack.push("three");
        myStack.push("four");
        myStack.push("five");
        System.out.println(myStack);
        myStack.remove(1);
        System.out.println(myStack);
        System.out.println(myStack.size());
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.size());
        System.out.println(myStack.pop());
        System.out.println(myStack.size());

    }
}
