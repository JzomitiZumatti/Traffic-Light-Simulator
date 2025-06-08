import java.util.Scanner;

public class Menu {
    Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void call() {
        System.out.println(Message.MSG_1);
        TrafficManager trafficManager = createTrafficManagerFromUserInput();
        int chooseOption;
        boolean isOn = true;
        do {
            System.out.println(Message.MSG_2);
            chooseOption = inputChecker();
            switch (chooseOption) {
                case 1 -> trafficManager.addRoad();
                case 2 -> trafficManager.deleteRoad();
                case 3 -> trafficManager.openSystem();
                case 0 -> {
                    isOn = false;
                    System.out.println(Message.MSG_11);
                }
                default -> System.out.println(Message.MSG_3);
            }
        } while (isOn);
    }

    private TrafficManager createTrafficManagerFromUserInput() {
        System.out.print(Message.MSG_4);
        int roads = inputChecker();

        System.out.print(Message.MSG_5);
        int interval = inputChecker();

        return new TrafficManager(roads, interval);
    }

    private int inputChecker() {
        Integer input = null;
        while (input == null) {
            try {
                input = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wrong input! Try again!");
            }
        }
        return input;
    }
}
