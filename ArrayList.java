public class ArrayList<T> implements List<T> {
    T[] arr;
    int size;

    public ArrayList(){
        arr = (T[]) new Object[10];
        size = 0;
    }
    public int size(){
        return size;
    }
    
    public boolean add(T item){
        if (size == arr.length){
            grow_array();
        }
        arr[size++] = item;
        return true;
    }

    public void add(int pos, T item) throws Exception{
        if (pos < 0 && pos >= size){
            throw new Exception("Invalid position");
        }
        if (size == arr.length){
            grow_array();
        }
        for(int i = size; i > pos; i--){
            arr[i] = arr[i - 1];
        }
        arr[pos] = item;
        ++size;
    }

    public T remove(int pos) throws Exception{
        if (pos < 0 && pos >= size){
            throw new Exception("Invalid position");
        }
        T item = arr[pos];
        for (int i = pos + 1; i < size; i++){
            arr[i - 1] = arr[i];
        }
        --size;
        return item;
    }

    public T get(int pos) throws Exception{
        if (pos < 0 && pos >= size){
            throw new Exception("Invalid position");
        }
        return arr[pos];
    }
    
    private void grow_array(){
        T[] new_arr = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++){
            new_arr[i] = arr[i];
        }
        arr = new_arr;
    }
}
