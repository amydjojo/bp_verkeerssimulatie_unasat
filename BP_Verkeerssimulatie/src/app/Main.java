package app;

import services.VerkeersSimulatieService;

public class Main {
    public static void main(String[] args) {
        VerkeersSimulatieService verkeersSimulatieService = new VerkeersSimulatieService();
        verkeersSimulatieService.startSimulatie();
    }
}