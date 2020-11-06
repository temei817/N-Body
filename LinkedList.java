public class LinkedList<T> implements List<T> {
    Node head;
    int size;
    private class Node<T>{
        T data;
        Node<T> next;

        public Node(T value){
            data = value;
            next = null;
        }
    }

    public LinkedList(){
        head = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean add (T item){
        if (head == null){
            head = new Node(item);
            ++size;
            return true;
        }
        Node<T> prev = head;
        for (int i = 0; i < size - 1; i++){
            prev = prev.next;
        }
        Node<T> node = new Node(item);
        prev.next = node;
        ++size;
        return true;
    }

    public void add(int pos, T item) throws Exception{
        if (pos < 0 && pos >= size){
            throw new Exception("Invalid position");
        }
        if (pos == 0){
            Node<T> node = new Node (item);
            node.next = head;
            head = node;
            ++size;
        }
        else{
            Node<T> prev = head;
            for(int i = 0; i < pos - 1; i++){
                prev = prev.next;
            }
            Node node = new Node(item);
            prev.next = node;
            ++size;
        }
    }

    public T get(int pos) throws Exception{
        if (pos < 0 && pos >= size){
            throw new Exception("Invalid position");
        }
        Node<T> curr = head;
        for (int i = 0; i < pos; i++){
            curr = curr.next;
        }
        return curr.data;
    }

    public T remove(int position) throws Exception{
        if (position < 0 && position >= size){
            throw new Exception("Invalid position");
        }
        if (position == 0){
            Node<T> node = head;
            head = head.next;
            --size;
            return node.data;
        }
        else{
            Node<T> prev = head;
            for(int i = 0; i < position - 1; i++){
                prev = prev.next;
            }
            Node<T> node = prev.next;
            prev.next = node.next;
            --size;
            return node.data;
        }
    }
}
