public class SystemState implements Runnable {
    private final TrafficManager manager;
    private volatile boolean running = true;
    private int timePassed = 0;

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
                    ConsoleUtils.clearConsole();
                    System.out.println("! " + timePassed + "s. have passed since system startup !");
                    System.out.println("! Number of roads: " + manager.getRoads() + " !");
                    System.out.println("! Interval: " + manager.getInterval() + " !");
                    System.out.println("! Press \"Enter\" to open menu !");
                }
            } catch (InterruptedException ignored) {}
        }
    }
}
