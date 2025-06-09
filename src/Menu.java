import java.io.IOException;
import java.util.Scanner;

public class Menu {
    Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void call() {
        TrafficManager trafficManager = createTrafficManagerFromUserInput();
        String chooseOption;
        boolean isOn = true;
        do {
            System.out.println(Message.MSG_2);
            chooseOption = scanner.nextLine();
            switch (chooseOption) {
                case "1" -> {
                    trafficManager.addRoad();
                    System.out.println();
                    scanner.nextLine();
                    clearConsole();
                }
                case "2" -> {
                    trafficManager.deleteRoad();
                    System.out.println();
                    scanner.nextLine();
                    clearConsole();
                }
                case "3" -> {
                    trafficManager.openSystem();
                    System.out.println();
                    scanner.nextLine();
                    clearConsole();
                }
                case "0" -> {
                    isOn = false;
                    System.out.println(Message.MSG_12);
                    System.out.println();
                }
                default -> {
                    System.out.println(Message.MSG_4);
                    System.out.println();
                    scanner.nextLine();
                    clearConsole();
                }
            }
        } while (isOn);
    }

    private TrafficManager createTrafficManagerFromUserInput() {
        System.out.println(Message.MSG_1);
        System.out.print(Message.MSG_5);
        int roads = Integer.parseInt(checkCorrectInput());

        System.out.print(Message.MSG_6);
        int interval = Integer.parseInt(checkCorrectInput());

        clearConsole();

        return new TrafficManager(roads, interval);
    }

    private String checkCorrectInput() {
        boolean isNumeric;
        String input = scanner.nextLine();
        try {
            Integer.parseInt(input.trim());
            isNumeric = true;
        } catch(NumberFormatException e){
            isNumeric = false;
        }
        while (!isNumeric || Integer.parseInt(input) == 0 || Integer.parseInt(input) < 0) {
            System.out.print(Message.MSG_3);
            input = scanner.nextLine();
            try {
                Integer.parseInt(input.trim());
                isNumeric = true;
            } catch(NumberFormatException e){
                isNumeric = false;
            }
        }
        return input;
    }

    private void clearConsole() {
        try {
            var clearCommand = System.getProperty("os.name").contains("Windows")
                    ? new ProcessBuilder("cmd", "/c", "cls")
                    : new ProcessBuilder("clear");
            clearCommand.inheritIO().start().waitFor();
        } catch (IOException | InterruptedException ignored) {}
    }
}