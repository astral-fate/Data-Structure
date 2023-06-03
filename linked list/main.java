import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MSLL<String> msll = new MSLL<>();
        Locale.setDefault(Locale.US);
        
        msll.addToMSLLHead("A");
        msll.addToMSLLHead("B");
        msll.addToMSLLHead("C");

        msll.displayMSLL();

       Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int choice = -1;

        while (choice != 13) {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter key: ");
                    String key1 = scanner.next();
                    msll.addToMSLLHead(key1);
                    break;
                    case 2:
                      System.out.print("Enter key: ");
                      String key2 = scanner.next();
                      MSLLNode<String> node = new MSLLNode<>(key2, new SLL<>(), null);
                      msll.addToMSLLTail(node);
                      break;


                case 3:
                    System.out.print("Enter key: ");
                    String key3 = scanner.next();
                    msll.deleteFromMSLL(key3);
                    break;
                case 4:
                    System.out.print("Enter key: ");
                    String key4 = scanner.next();
                    boolean isInList = msll.isInMSLL(key4);
                    System.out.println("Node with key '" + key4 + "' exists in MSLL: " + isInList);
                    break;
                case 5:
                    System.out.print("Enter key: ");
                    String key5 = scanner.next();
                    msll.makeCitySublistEmpty(key5);
                    break;
                case 6:
                    System.out.print("Enter key: ");
                    String key6 = scanner.next();
                    msll.deleteCitySublist(key6);
                    break;
                case 7:
                    System.out.print("Enter key: ");
                    String key7 = scanner.next();
                    msll.displayCitySublist(key7);
                    break;
                case 8:
                    System.out.print("Enter sublist key: ");
                    String sublistKey = scanner.next();
                    System.out.print("Enter city name: ");
                    String city8 = scanner.next();
                    System.out.print("Enter latitude: ");
                    double latitude = scanner.nextDouble();
                    System.out.print("Enter longitude: ");
                    double longitude = scanner.nextDouble();
                    msll.addCityToSublistAtRear(sublistKey, city8, latitude, longitude);
                    break;
                case 9:
                    System.out.print("Enter the sublist key: ");
                    String sublistKey9 = scanner.next();

                    System.out.print("Enter the city name: ");
                    String city9 = scanner.next();

                    System.out.print("Enter the position: ");
                    int position9 = scanner.nextInt();

                    System.out.print("Enter the latitude: ");
                    double latitude9 = scanner.nextDouble();

                    System.out.print("Enter the longitude: ");
                    double longitude9 = scanner.nextDouble();

                    msll.addCityToSublistAtPosition(city9, sublistKey9, position9, latitude9, longitude9);
                    break;
                case 10:
                    System.out.print("Enter city name: ");
                    String city10 = scanner.next();
                    msll.deleteCityFromSublist(city10);
                    break;
                case 11:
                    System.out.print("Enter name of city 1: ");
                    String city1 = scanner.next();
                    System.out.print("Enter name of city 2: ");
                    String city2 = scanner.next();

                    try {
                        double distance = msll.getDistance(city1, city2);
                        System.out.println("The straight-line distance between " + city1 + " and " + city2 + " is " + distance + " kilometers.");
                    } catch (NullPointerException e) {
                        System.out.println("One or both cities are not in the MSLL.");
                    }
                    break;
                case 12:
                    msll.displayMSLL();
                    break;
                case 13:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("===== Menu =====");
        System.out.println("1. Add a node to the head of the MSLL");
        System.out.println("2. Add a node to the tail of the MSLL");
        System.out.println("3. Delete a node from the MSLL");
        System.out.println("4. Check if a node exists in the MSLL");
        System.out.println("5. Make a city sublist empty");
        System.out.println("6. Delete a city sublist");
        System.out.println("7. Display a city sublist");
        System.out.println("8. Add a city to a sublist at the rear");
        System.out.println("9. Add a city to a sublist at a position");
        System.out.println("10. Delete a city from a sublist");
        System.out.println("11. Calculate the distance between two cities");
        System.out.println("12. Display the MSLL");
        System.out.println("13. Exit");
        System.out.println("================");
    }
}
