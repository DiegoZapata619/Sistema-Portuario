package DataStructures.Linear;

import DataStructures.Nodes.DoubleNode;


public class DoubleLinkedList<T> implements MyList<T> {
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int size;

    public DoubleLinkedList() {
        //Valores predeterminados
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index=" + index + ", size=" + size);
        }
        //Insertar al inicio
        if (index == 0) {
            DoubleNode<T> newNode = new DoubleNode<>(head, null, data);
            //Si la lista no está vacía, el nodo anterior a head es el nuevo nodo
            if (head != null) head.setPrev(newNode);
            head = newNode;
            //si el tamaño de lista es 0, head=tail=new Node
            if (size == 0) tail = newNode;
            size++;
            return;
        }
        //Insertar al final
        if (index == size) {
            DoubleNode<T> newNode = new DoubleNode<>(null, tail, data);
            if (tail != null) tail.setNext(newNode);
            tail = newNode;
            if (size == 0) head = newNode;
            size++;
            return;
        }
        //Insertar en medio de la lista
        DoubleNode<T> current = getTDoubleNode(index);
        //Luego de recorrer todos los nodos hasta el actual marcado por le índice, actualizamos
            //las referencias.
            DoubleNode<T> prev=current.getPrev();
            DoubleNode<T> newNode= new DoubleNode<>(current,prev,data);
            prev.setNext(newNode);
            current.setPrev(newNode);
            size++;

    }

    @Override
    public void addFirst(T data) {
        DoubleNode<T> newNode = new DoubleNode<>(head, null, data);
        if (head!=null) head.setPrev(newNode);
        head=newNode;
        if (size==0) tail=newNode;
        size++;
    }

    @Override
    public void addLast(T data) {
        DoubleNode<T> newNode = new DoubleNode<>(null, tail, data);
        if (tail!=null) tail.setNext(newNode);
        tail=newNode;
        if (size==0) head= newNode;
        size++;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index=" + index + ", size=" + size);
        }
        //Quitar primero
        if (index == 0) return removeFirst();
        //Quitar último
        if (index == size - 1) return removeLast();
        //Quitar en medio
        DoubleNode<T> current= getTDoubleNode(index);
        //Se obtiene el objeto de en medio de la lista
        T value = current.getElement();
        //Se establecen nuevas referencias
        DoubleNode<T> next= current.getNext();
        DoubleNode<T> prev= current.getPrev();
        prev.setNext(next);
        next.setPrev(prev);
        //Se disminuye tamaño de lista y se retorna valor
        size--;
        return value;
    }

    @Override
    public T removeFirst() {
        if (size==0) throw new IllegalStateException("La lista está vacía");
        T value= head.getElement();
        head= head.getNext();
        if (head!=null) head.setPrev(null);
        size--;
        if (size==0) tail=null;
        return value;
    }

    @Override
    public T removeLast() {
        if (size==0) throw new IllegalStateException("La lista está vacía");
        T value= tail.getElement();
        tail= tail.getPrev();
        if (tail!=null) tail.setNext(null);
        size--;
        if (size==0) head=null;
        return value;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        DoubleNode<T> current= getTDoubleNode(index);
        return current.getElement();
    }

    @Override
    public void set(int index, T data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        DoubleNode<T> current= getTDoubleNode(index);
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
        DoubleNode<T> current=head;
        //Se recorre toda la lista desde la cabeza
        while (current!=null){
            T valor = current.getElement();
            //Como no se puede usar equals sobre null, se hace una validación
            //Si el objeto buscado es null, solo retorna null si el valor del nodo es null
            if (obj==null){
                if (valor==null) return true;
            }
            else {
                if (obj.equals(valor)) return true;
            }
            current=current.getNext();
        }
        return false;
    }

    @Override
    public void clear() {
        head=null;
        tail=null;
        size=0;
    }

    //Metodo auxiliar sugerido por IntelliJ
    private DoubleNode<T> getTDoubleNode(int index) {
        DoubleNode<T> current;
        /* Truquito para optimizar
        Dependiendo de si el índice está en la mitad superior o inferior, se empieza a
        recorrer la lista desde head o desde tail.
         */
        if (index <= size / 2) {
            current = head;
            for (int i = 0; i < index; i++){
                current = current.getNext();
            }
        } else {
            current=tail;
            for (int i = size-1; i > index; i--) {
                current = current.getPrev();
            }
        }
        return current;
    }
}
