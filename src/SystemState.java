public class SystemState implements Runnable {
    private final TrafficManager manager;
    private volatile boolean running = true;
    private int timePassed = 0;
    private int currentOpenIndex = -1;

    private static final String Green = "\u001B[32m";
    private static final String Red = "\u001B[31m";
    private static final String Default = "\u001B[0m";

    public SystemState(TrafficManager manager) {
        this.manager = manager;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(1000);
                timePassed++;
                if (manager.getCurrentState() == State.SYSTEM) {
                    findOpenRoad();
                    ConsoleUtils.clearConsole();
                    System.out.println("! " + timePassed + "s. have passed since system startup !");
                    System.out.println("! Number of roads: " + manager.getRoads() + " !");
                    System.out.println("! Interval: " + manager.getInterval() + " !\n");
                    updateStates();
                    roadOutput();
                    System.out.println("\n! Press \"Enter\" to open menu !");
                    tick();
                }
            } catch (InterruptedException ignored) {
            }
        }
    }

    public void tick() {
        if (manager.getAllRoads().isEmpty()) return;
        for (Road road : manager.getAllRoads()) {
            road.setTimeRemaining(road.getTimeRemaining() - 1);
        }
    }

    public void updateStates() {
        if (manager.getAllRoads().isEmpty()) return;
        if (getCurrentRoad(currentOpenIndex) != null && getCurrentRoad(currentOpenIndex).getTimeRemaining() <= 0) {
            getCurrentRoad(currentOpenIndex).setState(false);
            currentOpenIndex = (currentOpenIndex + 1) % manager.getAllRoads().size();
            if (getCurrentRoad(currentOpenIndex) != null) {
                getCurrentRoad(currentOpenIndex).setState(true);
                getCurrentRoad(currentOpenIndex).setTimeRemaining(manager.getInterval());
            }
            updateRoadTimers();
        }

    }

    private void updateRoadTimers() {
        for (int i = 1; i < manager.getAllRoads().size(); i++) {
            int index = (currentOpenIndex + i) % manager.getAllRoads().size();
            Road road = manager.getAllRoads().get(index);
            road.setState(false);
            road.setTimeRemaining(manager.getInterval() * i);
        }
    }


    private void roadOutput() {
        if (manager.getAllRoads().isEmpty()) return;
        for (Road road : manager.getAllRoads()) {
            if (!road.getState()) {
                System.out.println(road.getName() + " will be " + Red + "closed for "
                        + (road.getTimeRemaining()) + "s." + Default);
            } else {
                System.out.println(road.getName() + " will be " + Green + "open for "
                        + (road.getTimeRemaining()) + "s." + Default);
            }
        }
    }

    private Road getCurrentRoad(int index) {
        return manager.getAllRoads().get(index);
    }

    private void findOpenRoad() {
        if (manager.getCurrentState() == State.SYSTEM) {
            for (int i = 0; i < manager.getAllRoads().size(); i++) {
                if (manager.getAllRoads().get(i).getState()) {
                    currentOpenIndex = i;
                    break;
                }
            }
        }
    }
}