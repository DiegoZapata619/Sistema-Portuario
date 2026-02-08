package DataStructures.Linear;

public interface MyList<T> {
    public void add(int index, T e);

    public void addFirst(T e);
    public void addLast(T e);

    public T remove(int index);
    public T removeFirst();
    public T removeLast();

    public T get(int index);
    public void set(int index, T e);

    public int size();
    public boolean isEmpty();

    public boolean contains(Object obj);

    public void clear();
}
