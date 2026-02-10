package DataStructures.Linear;

import DataStructures.Nodes.Node;

public class SimpleLinkedList<T> implements MyList<T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;

// Constructor para inicializar valores predeterminados
    public SimpleLinkedList() {
        head = null;
        tail = null;
        //Empezamos la lista desde el elemento 0
        size = 0;
    }
    @Override
    public void add(int index, T data) {
        if (index<0 || index> size){
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        //Si se inserta al inicio
        if (index==0){
            Node<T> newNode=new Node<>(data,head);
            head=newNode;
            if (size==0){
                tail=newNode;
            }
            size++;
            return;
        }
        //Si se inserta al final
        if (index == size) {
            Node<T> newNode = new Node<>(data, null);
            if (size == 0) {
                head = tail = newNode;
            } else {
                tail.setNext(newNode);
                tail = newNode;
            }
            size++;
            return;
        }
        //Si se inserta en el medio de la lista
        Node<T> prev = head;
        //Se recorre un elemento antes del final de la lista
        for (int i = 0; i < index - 1; i++) {
            prev = prev.getNext();
        }
        Node<T> newNode = new Node<>(data, prev.getNext());
        prev.setNext(newNode);
        size++;
    }

    @Override
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data, head);
        head = newNode;
        if (size == 0) tail = newNode;
        size++;
    }

    @Override
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data, null);

        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    @Override
    public T remove(int index) {
        if (index<0 || index>= size){
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        //Si se elimina al inicio de la lista
        if (index==0){
            T value= head.getElement();
            head= head.getNext();
            size--;
            if (size==0) tail=null;
            return value;
        }
        //Se busca el elemento anterior al que quiere ser eliminado
        Node<T> prev = head;
        for (int i=0;i<index-1;i++){
            prev=prev.getNext();
        }
        //Una vez se tiene al anterior, se obtiene el elemento que quiere ser eliminado
        Node<T> target=prev.getNext();
        T value=target.getElement();
        //Se establece que el elemento que sigue al anterior del objetivo sea el siguiente de este
        prev.setNext(target.getNext());

        //Como ya eliminados un elemento, actualizamos la cola
        if (target==tail){
            tail=prev;
        }
        size--;
        return value;
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            throw new IllegalStateException("Lista vacía");
        }
        T value = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0){
            tail = null;
        }
        return value;
    }

    @Override
    public T removeLast() {
        if (size==0){
            throw new IllegalStateException("Lista vacía");
        }
        //Si el tamaño es 1, el último elemento es la cabeza
        if (size==1){
            T value=head.getElement();
            head=tail=null;
            size=0;
            return value;
        }
        Node<T> prev=head;
        //Recorremos hasta el penúltimo elemento
        for (int i=0; i<size-2;i++){
            prev=prev.getNext();
        }
        size--;
        T value= tail.getElement();
        tail=prev;
        prev.setNext(null);
        return value;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        Node<T> current=head;
        for (int i=0;i<index;i++){
            current= current.getNext();
        }
        return current.getElement();
    }

    @Override
    public void set(int index, T data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        Node<T> current=head;
        for (int i=0;i<index;i++){
            current= current.getNext();
        }
      current.setElement(data);

    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object obj) {
        Node<T> current=head;
        //Se recorre elemento por elemento
        while(current!=null){
            T value= current.getElement();
            //Como no se puede usar equals sobre null, se hace una validación
            //Si el objeto buscado es null, solo retorna null si el valor del nodo es null
            if (obj==null){
                if (value==null) return true;
            }
            else {
                if (obj.equals(value)) return true;
            }
            current=current.getNext();
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
}
