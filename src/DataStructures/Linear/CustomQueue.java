package DataStructures.Linear;

import DataStructures.Nodes.Node;

public class CustomQueue<T> implements MyQueue<T> {
    private int size;
    private Node<T> head;

    //Constructor para inicilizar valores
    public CustomQueue(){
        size=0;
        head=null;
    }

    @Override
    //Metodo estricto de offer. Mismo funcionamiento pero arroja excepción si el elemento es null
    public void enqueue(T data) {
        if (!offer(data)){
            throw new IllegalStateException("La cola está vacía");
        }
    }

    @Override
    //Metodo estricto de poll. Mismo funcionamiento pero arroja excepción si el elemento es null
    public T dequeue() {
        T value=poll();
        if (value==null){
            throw new IllegalStateException("La cola está vacía");
        }
        return value;
    }

    @Override
    //Metodo estricto de peek. Mismo funcionamiento pero arroja excepción si el elemento es null
    public T element() {
        T value=peek();
        if (value==null){
            throw new IllegalStateException("La cola está vacía");
        }
        return value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T peek() {
        //Operador ternario porque se ve profesional
        return isEmpty()? null : head.getElement();
    }

    @Override
    public T poll() {
        if (isEmpty()) return null;
        T value = head.getElement();
        head = head.getNext();
        size--;
        return value;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
    //Introduce elementos en la cola, no permite null como elemento
    @Override
    public boolean offer(T data) {
        if (data==null) return false;
        Node<T> newNode= new Node<>(data,head);
        if (isEmpty()){
            head=newNode;
        } else {
            Node<T> current= head;
            while(current.getNext()!=null){
                current=current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
        return true;
    }
}

