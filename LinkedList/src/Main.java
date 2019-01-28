// Pulkit Verma
// Class (CECS 274-05)
// Project Name (Program 3 - Linked List)
// Due Date (Oct 18, 2018)

import java.util.Random;
import java.util.Scanner;

public class Main {

    // This method prints the menu on the screen
    public static void printMenu(int size, int average) {
        System.out.printf("\n\n(R)emove     (N)ew     (F)ind     Size: %d     Ave: %d     (Q)uit", size, average);
    }

    // This method asks the user to enter a menu option and validates the user input
    public static int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n\nPlease select a menu option: \n");
        char menuOption = scanner.next().toLowerCase().charAt(0);

        while (menuOption != "remove".charAt(0) && menuOption != "new".charAt(0) && menuOption != "find".charAt(0) && menuOption != "quit".charAt(0)) {
            System.out.print("\nPlease select a valid menu option: \n");
            menuOption = scanner.next().toLowerCase().charAt(0);
        }

        if (menuOption == "Remove".toLowerCase().charAt(0)) {
            return 1;
        } else if (menuOption == "New".toLowerCase().charAt(0)) {
            return 2;
        } else if (menuOption == "Find".toLowerCase().charAt(0)) {
            return 3;
        }
        return 4;
    }

    public static void main(String[] args) {

        Random random = new Random();
        int randomNumber;
        LinkedList linkedList = new LinkedList();
        int randomPosition;
        for (int i = 0; i < 5; i++) {
            randomNumber = random.nextInt(90000) + 10000;
            linkedList.addItem(randomNumber);
        }

        linkedList.displayList();
        printMenu(linkedList.size(), linkedList.average());
        int menuOption = menu();

        while (menuOption != 4) {

            switch (menuOption) {
                case 1:
                    if (linkedList.isEmpty() == false) {
                        randomPosition = random.nextInt(linkedList.size()) + 1;
                        int removedNumber = linkedList.remove(randomPosition);
                        System.out.printf("%d was removed from %d\n", removedNumber, randomPosition);
                        linkedList.displayList();
                    } else {
                        System.out.println("The list is empty, no more items can be removed.");
                    }
                    break;
                case 2:
                    randomNumber = random.nextInt(90000) + 10000;
                    int position = linkedList.addItem(randomNumber);
                    System.out.printf("%d was added to location %d\n", randomNumber, position);
                    linkedList.displayList();
                    break;
                case 3:
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Please enter a number: ");
                    int number = scanner.nextInt();
                    int found = linkedList.find(number);
                    if (found != 0) {
                        System.out.printf("%d found in location %d", number, found);
                    } else {
                        System.out.printf("%d not found", number);
                    }
                    break;
            }

            System.out.print("\n");
            printMenu(linkedList.size(), linkedList.average());
            menuOption = menu();
        }
    }
}
