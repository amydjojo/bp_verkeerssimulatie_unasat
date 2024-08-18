package queue;

import models.Vehicle;
import java.util.ArrayList;
import java.util.List;

// Custom class for priority queue
public class CustomPriorityQueue {
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

    public boolean offer(Vehicle vehicle) {
        return add(vehicle); // Same as add()
    }

    public Vehicle poll() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.remove(0);
    }

    public Vehicle peek() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.get(0);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    // Methods that are not needed for this implementation can throw UnsupportedOperationException
    public Vehicle remove() {
        throw new UnsupportedOperationException();
    }

    public Vehicle element() {
        throw new UnsupportedOperationException();
    }

    public boolean contains(Object o) {
        return queue.contains(o);
    }

    // Implement custom containsAll without Collection
    public boolean containsAll(List<?> c) {
        for (Object item : c) {
            if (!queue.contains(item)) {
                return false;
            }
        }
        return true;
    }

    // Implement custom iterator manually
    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>(queue);
    }

    public boolean remove(Object o) {
        return queue.remove(o);
    }

    // Implement custom addAll without Collection
    public boolean addAll(List<? extends Vehicle> c) {
        boolean modified = false;
        for (Vehicle vehicle : c) {
            if (add(vehicle)) {
                modified = true;
            }
        }
        return modified;
    }

    public boolean removeAll(List<?> c) {
        boolean modified = false;
        for (Object item : c) {
            if (queue.remove(item)) {
                modified = true;
            }
        }
        return modified;
    }

    public boolean retainAll(List<?> c) {
        boolean modified = false;
        List<Vehicle> toRemove = new ArrayList<>();
        for (Vehicle vehicle : queue) {
            if (!c.contains(vehicle)) {
                toRemove.add(vehicle);
                modified = true;
            }
        }
        queue.removeAll(toRemove);
        return modified;
    }

    public void clear() {
        queue.clear();
    }
}
