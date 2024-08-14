package models;

public class Node<T> {
    private T data;
    private Node<T> next;
    private Node<T> previous; // Optional, useful for doubly linked lists

    // Constructor for singly linked list node
    public Node(T data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    // Constructor for doubly linked list node
    public Node(T data, Node<T> next, Node<T> previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
}
