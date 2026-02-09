package DataStructures.Nodes;

public class DoubleNode<T> {
    private T element;
    private DoubleNode<T> next;
    private DoubleNode<T> prev;

    //Costructor
    public DoubleNode (DoubleNode<T> next, DoubleNode<T> prev, T element){
        this.next=next;
        this.prev=prev;
        this.element=element;
    }

    //Getters y Setters
    public DoubleNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    public DoubleNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DoubleNode<T> prev) {
        this.prev = prev;
    }


    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }
}
