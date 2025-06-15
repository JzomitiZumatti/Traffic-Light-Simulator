public enum Message {
    MSG_1("Welcome to the traffic management system!"),
    MSG_2("""
            Menu:
            1. Add
            2. Delete
            3. System
            0. Quit"""),
    MSG_3("Error! Incorrect Input. Try again: "),
    MSG_4("Incorrect option"),
    MSG_5("Input the number of roads: "),
    MSG_6("Input the interval: "),
    MSG_7(" Added!"),
    MSG_8(" deleted"),
    MSG_9("Queue is empty"),
    MSG_10("Queue is full"),
    MSG_11("Bye!");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
