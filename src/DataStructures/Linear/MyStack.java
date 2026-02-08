package DataStructures.Linear;

//Interfaz para stack usando generics.

public interface MyStack<T> {

    //Metodos fundamentales de Stack vistos en clase
    public void push(T dato);
    public T pop();
    public T peek();
    public int size();
    //search devuelve posición usando el tope.
    public int search(T data);
    public boolean isEmpty();


}
