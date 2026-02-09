package DataStructures.Linear;

public interface MyList<T> {
    public void add(int index, T data);

    public void addFirst(T data);
    public void addLast(T data);

    public T remove(int index);
    public T removeFirst();
    public T removeLast();

    public T get(int index);
    public void set(int index, T data);

    public int size();
    public boolean isEmpty();

    public boolean contains(Object obj);

    public void clear();
}
