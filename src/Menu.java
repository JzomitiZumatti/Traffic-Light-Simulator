import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Menu {
    Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
    }

    public void call() {
        System.out.println(Message.MSG_1);
        System.out.print(Message.MSG_5);
        int roads = Integer.parseInt(checkCorrectInput());
        RoadQueue roadQueue = new RoadQueue(roads);
        TrafficManager trafficManager = createTrafficManagerFromUserInput(roads, roadQueue);
        SystemState systemState = new SystemState(trafficManager);
        Thread queueThread = new Thread(systemState);
        queueThread.setName("QueueThread");
        queueThread.start();
        String chooseOption;
        boolean isOn = true;
        do {
            System.out.println(Message.MSG_2);
            chooseOption = scanner.nextLine().trim().replace("\r", "");
            switch (chooseOption) {
                case "1" -> {
                    System.out.print("Input road name: ");
                    String roadName = scanner.nextLine().trim().replace("\r", "");
                    trafficManager.addRoad(roadName);
                    scanner.nextLine();
                    ConsoleUtils.clearConsole();
                }
                case "2" -> {
                    trafficManager.deleteRoad();
                    scanner.nextLine();
                    ConsoleUtils.clearConsole();
                }
                case "3" -> {
                    trafficManager.setCurrentState(State.SYSTEM);
                    scanner.nextLine().trim().replace("\r", "");
                    trafficManager.setCurrentState(State.MENU);
                    ConsoleUtils.clearConsole();
                }
                case "0" -> {
                    isOn = false;
                    systemState.stop();
                    try {
                        queueThread.join();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("Main thread was interrupted while waiting for QueueThread to finish.");
                    }
                    System.out.println(Message.MSG_11);
                    System.out.println();
                }
                default -> {
                    System.out.println(Message.MSG_4);
                    scanner.nextLine();
                    ConsoleUtils.clearConsole();
                }
            }
        } while (isOn);
    }

    private TrafficManager createTrafficManagerFromUserInput(int roads, RoadQueue roadQueue) {
        System.out.print(Message.MSG_6);
        int interval = Integer.parseInt(checkCorrectInput());

        ConsoleUtils.clearConsole();

        return new TrafficManager(roads, interval, roadQueue);
    }

    private String checkCorrectInput() {
        boolean isNumeric;
        String input = scanner.nextLine().trim().replace("\r", "");
        try {
            Integer.parseInt(input);
            isNumeric = true;
        } catch (NumberFormatException e) {
            isNumeric = false;
        }
        while (!isNumeric || Integer.parseInt(input) <= 0) {
            System.out.print(Message.MSG_3);
            input = scanner.nextLine().trim().replace("\r", "");
            try {
                Integer.parseInt(input);
                isNumeric = true;
            } catch (NumberFormatException e) {
                isNumeric = false;
            }
        }
        return input;
    }
}