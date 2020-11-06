public interface List<T> {
    public T get(int pos) throws Exception;
    public boolean add(T item);
    public void add(int pos, T item) throws Exception;
    public T remove(int pos) throws Exception;
    public int size();
}
