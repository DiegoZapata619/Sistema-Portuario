package DataStructures.Nodes;

//Nodo usando generics para trabajar cualquier tipo de elemento

public class Node<T>{
    private T element;
    private Node<T> next;

    //Constructor
    public Node (T element, Node nex){
        this.element=element;
        this.next=next;
    }

    //Getters y Setters
    public T getElement() {
        return element;
    }
    public void setElement(T element) {
        this.element = element;
    }
    public Node<T> getNext(){
        return next;
    }
    public void setNext(Node<T> next){
        this.next=next;
    }







}
