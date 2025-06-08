public enum Message {
    MSG_1("Welcome to the traffic management system!"),
    MSG_2("""
            Menu:
            1. Add
            2. Delete
            3. System
            0. Quit"""),
    MSG_3("You select wrong option! Try again!"),
    MSG_4("Input the number of roads: "),
    MSG_5("Input the interval: "),
    MSG_6("Road added"),
    MSG_7("Road deleted"),
    MSG_8("No more roads to delete!"),
    MSG_9("System opened"),
    MSG_10("System already opened"),
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
