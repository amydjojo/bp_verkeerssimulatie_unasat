package datastructures;

public class VehicleLinkedList <T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public VehicleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Add an element to the end of the list
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }
    // Add an element to the front of the list
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }
    // Remove and return the first element
    public T removeFirst() {
        T data = head.getData();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        size--;
        return data;
    }

    // Get the first element without removing it
    public T getFirst() {

        return head.getData();
    }

    public T remove() {
        if (head == null) {
            return null;
        }
        T data = head.getData();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        size--;
        return data;
    }

    public T peek() {
        return (head == null) ? null : head.getData();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
