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

    public Vehicle poll() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.remove(0);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

}
