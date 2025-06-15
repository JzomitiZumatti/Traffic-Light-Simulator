import java.util.List;

public class TrafficManager {
    private final int roads;
    private final int interval;
    private State currentState = State.NOT_STARTED;
    private final RoadQueue roadQueue;

    public TrafficManager(int roads, int interval, RoadQueue roadQueue) {
        this.roads = roads;
        this.interval = interval;
        this.roadQueue = roadQueue;
    }

    public void addRoad(String roadName) {
        roadQueue.enqueue(roadName);
    }

    public void deleteRoad() {
        roadQueue.dequeue();
    }

    public int getRoads() {
        return roads;
    }

    public List<String> getAllRoads() {
        return roadQueue.getAll();
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
