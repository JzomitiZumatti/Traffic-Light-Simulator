public class Road {
    String name;
    boolean state;
    int timeRemaining;

    public Road(String name, boolean state, int timeRemaining) {
        this.name = name;
        this.state = state;
        this.timeRemaining = timeRemaining;
    }

    public String getName() {
        return name;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getTimeRemaining() {
        return timeRemaining;
    }

    public void setTimeRemaining(int timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    @Override
    public String toString() {
        return "Road{name='" + name + "', state=" + state + ", timeRemaining=" + timeRemaining + "}";
    }
}