import java.util.ArrayList;
import java.util.List;

public class RoadQueue {
    private final int maxSize;
    private final Road[] queueArray;
    private int front;
    private int rear;
    private int size;

    public RoadQueue(int size) {
        maxSize = size;
        queueArray = new Road[maxSize];
        front = -1;
        rear = -1;
        this.size = 0;
    }

    public void enqueue(String name, int interval) {
        if (size == maxSize) {
            System.out.println(Message.MSG_10);
            return;
        }

        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % maxSize;
        }
        Road road;
        if (size == 0) {
            road = new Road(name, true, interval);
        } else {
            int currentOpenIndex = front;
            int currentOpenTime = queueArray[currentOpenIndex].getTimeRemaining();
            road = new Road(name, false, currentOpenTime + interval * (size - 1));
        }
        queueArray[rear] = road;
        size++;
        System.out.println(road.getName() + Message.MSG_7);
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println(Message.MSG_9);
            return;
        }

        Road road = queueArray[front];
        queueArray[front] = null;
        size--;

        System.out.println(road.getName() + Message.MSG_8);

        if (isEmpty()) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % maxSize;
        }

    }

    public List<Road> getAll() {
        if (isEmpty()) {
            return List.of();
        }

        List<Road> result = new ArrayList<>();
        int current = front;
        for (int i = 0; i < size; i++) {
            if (queueArray[current] != null) {
                result.add(queueArray[current]);
            }
            current = (current + 1) % maxSize;
        }
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}




