public class TrafficManager {
    private int roads;
    private final int interval;
    private boolean systemOpen;


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

    public void openSystem() {
        if (systemOpen) {
            System.out.println(Message.MSG_11);
        } else {
            systemOpen = true;
            System.out.println(Message.MSG_10);
        }
    }
}
