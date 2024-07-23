package services;

import models.Car;
import models.Wegdek;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class VerkeersSimulatieService {
    private final String NOORD = "Noord";
    private final String ZUID = "Zuid";
    private final String OOST = "Oost";
    private final String WEST = "West";
    private String[] verkeersLicht = {NOORD, ZUID, OOST, WEST};
    private Wegdek wegdekNoord;
    private Wegdek wegdekZuid;
    private Wegdek wegdekOost;
    private Wegdek wegdekWest;

    public VerkeersSimulatieService() {
        init();
    }

    public void init() {
        // data setup
        wegdekNoord = new Wegdek(NOORD, createCarList(new String[]{"Auto1", "Auto2", "Auto3", "Politie met sirene"}, new int[]{2, 3, 4, 1}));
        wegdekZuid = new Wegdek(ZUID, createCarList(new String[]{"Auto4", "Auto5", "Auto6", "Brandweer met sirene"}, new int[]{2, 3, 4, 1}));
        wegdekOost = new Wegdek(OOST, createCarList(new String[]{"Auto7", "Auto8", "Auto9"}, new int[]{2, 3, 4}));
        wegdekWest = new Wegdek(WEST, createCarList(new String[]{"Auto10", "Auto11", "Auto12", "Politie met sirene"}, new int[]{2, 3, 4, 1}));
    }

    private List<Car> createCarList(String[] names, int[] priorities) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            carList.add(new Car(names[i], priorities[i], "XX-000-XX"));
        }
        return carList;
    }

    public void startSimulatie() {
        Queue<Car> queueNoord = new PriorityQueue<>(Comparator.comparingInt(Car::getCarPriority));
        Queue<Car> queueZuid = new PriorityQueue<>(Comparator.comparingInt(Car::getCarPriority));
        Queue<Car> queueOost = new PriorityQueue<>(Comparator.comparingInt(Car::getCarPriority));
        Queue<Car> queueWest = new PriorityQueue<>(Comparator.comparingInt(Car::getCarPriority));

        queueNoord.addAll(wegdekNoord.getCarList());
        queueZuid.addAll(wegdekZuid.getCarList());
        queueOost.addAll(wegdekOost.getCarList());
        queueWest.addAll(wegdekWest.getCarList());

        boolean carsRemaining = true;
        int round = 1;

        while (carsRemaining) {
            carsRemaining = false;
            System.out.println("\n--- Start of Round " + round + " ---");

            for (String verkeersLichtNaam : verkeersLicht) {
                Queue<Car> currentQueue = null;

                switch (verkeersLichtNaam) {
                    case NOORD:
                        currentQueue = queueNoord;
                        break;
                    case ZUID:
                        currentQueue = queueZuid;
                        break;
                    case OOST:
                        currentQueue = queueOost;
                        break;
                    case WEST:
                        currentQueue = queueWest;
                        break;
                }

                if (currentQueue != null && !currentQueue.isEmpty()) {
                    System.out.println("Verkeerslicht staat op groen voor " + verkeersLichtNaam);
                    int carsToPass = Math.min(5, currentQueue.size());
                    for (int j = 0; j < carsToPass; j++) {
                        Car car = currentQueue.poll();
                        System.out.println(car.getCarName() + " rijdt over het wegdek " + verkeersLichtNaam);
                    }
                } else {
                    System.out.println("Geen auto's op wegdek " + verkeersLichtNaam);
                }

                carsRemaining = carsRemaining || (currentQueue != null && !currentQueue.isEmpty());
            }

            System.out.println("--- End of Round " + round + " ---\n");
            round++;
        }

        // Reverse Playback
        reversePlayback(queueNoord, wegdekNoord);
        reversePlayback(queueZuid, wegdekZuid);
        reversePlayback(queueOost, wegdekOost);
        reversePlayback(queueWest, wegdekWest);
    }

    private void reversePlayback(Queue<Car> queue, Wegdek wegdek) {
        List<Car> carList = wegdek.getCarList();
        System.out.println("\n--- Reverse Playback voor wegdek " + wegdek.getWegdekNaam() + " ---");
        for (int i = carList.size() - 1; i >= 0; i--) {
            queue.offer(carList.get(i));
            System.out.println(carList.get(i).getCarName() + " is terug op wegdek " + wegdek.getWegdekNaam());
        }
        System.out.println("--- Einde van Reverse Playback voor wegdek " + wegdek.getWegdekNaam() + " ---\n");
    }
}
