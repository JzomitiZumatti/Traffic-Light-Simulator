public class TrafficManager {
    private int roads;
    private final int interval;
    private State currentState = State.NOT_STARTED;


    public TrafficManager(int roads, int interval) {
        this.roads = roads;
        this.interval = interval;
    }

    public void addRoad() {
        roads++;
        System.out.println(Message.MSG_7);
    }

    public void deleteRoad() {
        if (roads > 0) {
            roads--;
            System.out.println(Message.MSG_8);
        } else {
            System.out.println(Message.MSG_9);
        }
    }

    public int getRoads() {
        return roads;
    }

    public int getInterval() {
        return interval;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }
}
