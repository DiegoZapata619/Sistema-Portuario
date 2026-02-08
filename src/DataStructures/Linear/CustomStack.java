
package DataStructures.Linear;
import DataStructures.Nodes.Node;

public class CustomStack<T> implements MyStack<T> {

    private Node<T> stackPointer;
    private int size;

    //Constructor para inicializar valores predeterminados
    public CustomStack (){
        stackPointer=null;
        size=0;
    }

    @Override
    public void push(T dato) {
        stackPointer= new Node<>(dato,stackPointer);
        size++;

    }
    @Override
    public T pop() {
        if (isEmpty()){
            throw new IllegalStateException("Pila vacía");
        }
        T value=stackPointer.getElement();
        stackPointer=stackPointer.getNext();
        return value;
    }

    @Override
    public T peek() {
        if (isEmpty()){
            throw new IllegalStateException("Pila vacía");
        }
        return stackPointer.getElement();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    //Recorre toda la pila desde la cima hasta encontrar al elemento
    public int search(T data) {
        Node<T> current=stackPointer;
        int position=1;
        while (current!=null){
            if (current.getElement().equals(data)){
                return position;
            }
        }
        //Si no encuentra el elemento, informa y devuelve -1
        System.out.println("El elemento no está en la pila");
        return -1;

    }
    @Override
    public boolean isEmpty() {
        return size==0;
    }
}
