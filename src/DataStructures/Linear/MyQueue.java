package DataStructures.Linear;

//Interfaz para queue usando generics.
public interface MyQueue<T> {
    public void enqueue(T data);
    public T dequeue();
    public T element();
    public int size();
    public T peek();
    public T poll();
    public boolean isEmpty();
    public boolean offer(T data);

}