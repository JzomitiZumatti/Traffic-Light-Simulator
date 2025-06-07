public enum Message {
    MSG_1("Welcome to the traffic management system!"),
    MSG_2("""
            Menu:
            1. Add
            2. Delete
            3. System
            0. Quit
            """),
    MSG_3("You select wrong option! Try again!");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
