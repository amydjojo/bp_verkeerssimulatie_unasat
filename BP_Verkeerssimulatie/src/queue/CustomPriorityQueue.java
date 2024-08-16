package queue;

import models.Vehicle;

import java.util.*;

//custom class for priority queue
public class CustomPriorityQueue implements Queue<Vehicle> {
    private List<Vehicle> queue;

    public CustomPriorityQueue() {
        queue = new ArrayList<>();
    }

    @Override
    public boolean add(Vehicle vehicle) {
        int i = 0;
        while (i < queue.size() && queue.get(i).getPriority() <= vehicle.getPriority()) {
            i++;
        }
        queue.add(i, vehicle);
        return true;
    }

    @Override
    public boolean offer(Vehicle vehicle) {
        return add(vehicle); // Same as add()
    }

    @Override
    public Vehicle poll() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.remove(0);
    }

    @Override
    public Vehicle peek() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.get(0);
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int size() {
        return queue.size();
    }

    // Methods that are not needed for this implementation can throw UnsupportedOperationException
    @Override
    public Vehicle remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Vehicle element() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object o) {
        return queue.contains(o);
    }

    @Override
    public Iterator<Vehicle> iterator() {
        return queue.iterator();
    }

    @Override
    public Object[] toArray() {
        return queue.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return queue.toArray(a);
    }

    @Override
    public boolean remove(Object o) {
        return queue.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return queue.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Vehicle> c) {
        return queue.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return queue.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return queue.retainAll(c);
    }

    @Override
    public void clear() {
        queue.clear();
    }
}
