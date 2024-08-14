package queue;

import models.Vehicle;

import java.util.*;

public class CustomPriorityQueue implements Queue<Vehicle> {
    private List<Vehicle> queue;

    public CustomPriorityQueue() {
        queue = new ArrayList<>();
    }

    public boolean add(Vehicle vehicle) {
        int i = 0;
        while (i < queue.size() && queue.get(i).getPriority() <= vehicle.getPriority()) {
            i++;
        }
        queue.add(i, vehicle);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Vehicle> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean offer(Vehicle vehicle) {
        return false;
    }

    @Override
    public Vehicle remove() {
        return null;
    }

    public Vehicle poll() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.remove(0);
    }

    @Override
    public Vehicle element() {
        return null;
    }

    @Override
    public Vehicle peek() {
        return null;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Vehicle> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    public int size() {
        return queue.size();
    }
}
