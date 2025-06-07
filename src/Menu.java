import java.util.Scanner;

public class Menu {
    Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void call() {
        String chooseOption;
        boolean isOn = true;
        do {
            printMenu();
            chooseOption = scanner.nextLine();
            switch (chooseOption) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "0":
                    isOn = false;
                    break;
                default:
                    System.out.println(Message.MSG_3);
            }
        } while (isOn);
    }

    private void printMenu() {
        System.out.println(Message.MSG_1);
        System.out.println(Message.MSG_2);
    }

}
