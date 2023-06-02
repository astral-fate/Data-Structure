import java.util.Scanner;

public class MSLL<T> {
private MSLLNode<T> head;
private Scanner scanner;
public MSLL() {
    this.head = null;
    this.scanner = new Scanner(System.in);
}

public MSLLNode<T> getHead() {
    return head;
}

public void addToMSLLHead(String key) throws IllegalArgumentException {
    if (isInMSLL(key)) {
        throw new IllegalArgumentException("Node with key '" + key + "' already exists in MSLL.");
    }

    SLL<T> sublist = new SLL<>();
    MSLLNode<T> newNode = new MSLLNode<>(key, sublist, head);
    head = newNode;
}

public void addToMSLLTail(String key) throws IllegalArgumentException {
    if (isInMSLL(key)) {
        throw new IllegalArgumentException("Node with key '" + key + "' already exists in MSLL.");
    }

    SLL<T> sublist = new SLL<>();
    MSLLNode<T> newNode = new MSLLNode<>(key, sublist, null);

    if (head == null) {
        head = newNode;
    } else {
        MSLLNode<T> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
    }
}

public void deleteFromMSLL(String key) throws IllegalArgumentException {
    if (head == null) {
        throw new IllegalArgumentException("Node with key '" + key + "' does not exist.");
    }

    if (head.getKey().equals(key)) {
        head = head.getNext();
        return;
    }

    MSLLNode<T> current = head;
    while (current.getNext() != null) {
        if (current.getNext().getKey().equals(key)) {
            current.setNext(current.getNext().getNext());
            return;
        }
        current = current.getNext();
    }

    throw new IllegalArgumentException("Node with key '" + key + "' does not exist.");
}

public boolean isInMSLL(String key) {
    MSLLNode<T> current = head;
    while (current != null) {
        if (current.getKey().equals(key)) {
            return true;
        }
        current = current.getNext();
    }
    return false;
}

public void makeCitySublistEmpty(String key) throws IllegalArgumentException {
    MSLLNode<T> current = findNode(key);
    if (current == null) {
        throw new IllegalArgumentException("Node with key '" + key + "' does not exist.");
    }

    current.getList().makeEmpty();
}

public void deleteCitySublist(String key) throws IllegalArgumentException {
    if (head == null) {
        throw new IllegalArgumentException("Node with key '" + key + "' does not exist.");
    }

    if (head.getKey().equals(key)) {
        head = head.getNext();
        return;
    }

    MSLLNode<T> current = head;
    while (current.getNext() != null) {
        if (current.getNext().getKey().equals(key)) {
            current.setNext(current.getNext().getNext());
            return;
        }
        current = current.getNext();
    }

    throw new IllegalArgumentException("Node with key '" + key + "' does not exist.");
}

public void displayCitySublist(String key) throws IllegalArgumentException {
    MSLLNode<T> current = findNode(key);
    if (current == null) {
        throw new IllegalArgumentException("Node with key '" + key + "' does not exist.");
    }

    current.getList().displayList();
}

public void addCityToSublistAtRear(T city, String sublistKey) throws IllegalArgumentException {
    MSLLNode<T> sublistNode = findNode(sublistKey);
    if (sublistNode == null) {
        throw new IllegalArgumentException("Sublist with key '" + sublistKey + "' does not exist.");
    }

    sublistNode.getList().addToSLLTail(city);
}

public void addCityToSublistAtFront(T city, String sublistKey) throws IllegalArgumentException {
    MSLLNode<T> sublistNode = findNode(sublistKey);
    if (sublistNode == null) {
        throw new IllegalArgumentException("Sublist with key '" + sublistKey + "' does not exist.");
    }

    sublistNode.getList().addToSLLHead(city);
}

private MSLLNode<T> findNode(String key) {
    MSLLNode<T> current = head;
    while (current != null) {
        if (current.getKey().equals(key)) {
            return current;
        }
        current = current.getNext();
    }
    return null;
}

public void displayMSLL() {
    MSLLNode<T> current = head;
    while (current != null) {
        System.out.println("Key: " + current.getKey());
        System.out.println("Sublist:");
        current.getList().displayList();
        System.out.println("--------------------");
        current = current.getNext();
    }
}

public void runMenu() {
    int choice = -1;

    while (choice != 13) {
        displayMenu();
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter key: ");
                String key1 = scanner.next();
                addToMSLLHead(key1);
                break;
            case 2:
                System.out.print("Enter key: ");
                String key2 = scanner.next();
                addToMSLLTail(key2);
                break;
            case 3:
                System.out.print("Enter key: ");
                String key3 = scanner.next();
                deleteFromMSLL(key3);
                break;
            case 4:
                System.out.print("Enter key: ");
                String key4 = scanner.next();
                boolean isInList = isInMSLL(key4);
                System.out.println("Node with key '" + key4 + "' exists in MSLL: " + isInList);
                break;
            case 5:
                System.out.print("Enter key: ");
                String key5 = scanner.next();
                makeCitySublistEmpty(key5);
                break;
            case 6:
                System.out.print("Enter key: ");
                String key6 = scanner.next();
                deleteCitySublist(key6);
                break;
            case 7:
                System.out.print("Enter key: ");
                String key7 = scanner.next();
                displayCitySublist(key7);
                break;
            case 8:
                System.out.print("Enter city name: ");
                String city8 = scanner.next();
                addCityToSublistAtRear(null, city8);  // TODO: Pass the city object as an argument
                break;
            case 9:
                System.out.print("Enter sublist key: ");
                String sublistKey9 = scanner.next();
                System.out.print("Enter city name: ");
                String city9 = scanner.next();
                System.out.print("Enter position: ");
                int position9 = scanner.nextInt();
                addCityToSublistAtPosition((T) city9, sublistKey9, position9);
                break;

            case 10:
                System.out.print("Enter city name: ");
                String city10 = scanner.next();
                deleteCityFromSublist(city10);
                break;
            case 11:
                System.out.print("Enter latitude of city 1: ");
                double latitude1 = scanner.nextDouble();
                System.out.print("Enter longitude of city 1: ");
                double longitude1 = scanner.nextDouble();
                System.out.print("Enter latitude of city 2: ");
                double latitude2 = scanner.nextDouble();
                System.out.print("Enter longitude of city 2: ");
                double longitude2 = scanner.nextDouble();
                double distance = getDistance(latitude1, longitude1, latitude2, longitude2);
                System.out.println("Distance between cities: " + distance + " km");
                break;
            case 12:
                System.out.print("Enter city name: ");
                String city12 = scanner.next();
                boolean cityFound = searchForCity(city12);
                System.out.println("City " + city12 + " found: " + cityFound);
                break;
            case 13:
                System.out.println("Exiting the program.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }

        System.out.println();
    }

    scanner.close();
}

private boolean searchForCity(String city12) {
    MSLLNode<T> current = head;
    while (current != null) {
        if (current.getList().isInSLL(city12)) {
            return true;
        }
        current = current.getNext();
    }
    return false;
}

private double getDistance(double lat1, double lon1, double lat2, double lon2) {
    int R = 6371; // Radius of the earth in kilometers
    double latDistance = Math.toRadians(lat2 - lat1);
    double lonDistance = Math.toRadians(lon2 - lon1);
    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    double distance = R * c;
    return distance;
}

private void deleteCityFromSublist(String city10) {
    MSLLNode<T> current = head;
    while (current != null) {
        current.getList().deleteFromSLL(city10);
        current = current.getNext();
    }
}

public void addCityToSublistAtPosition(T city, String sublistKey, int position) {
    MSLLNode<T> sublistNode = findNode(sublistKey);
    if (sublistNode == null) {
        System.out.println("Sublist with key '" + sublistKey + "' does not exist.");
        return;
    }

    SLL<T> sublist = sublistNode.getList();
    if (position < 1 || position > sublist.getSize() + 1) {
        System.out.println("Invalid position. Position should be between 1 and " + (sublist.getSize() + 1));
        return;
    }

    // Create a new city object or modify the code to pass an actual city object

    if (position == 1) {
        sublist.addToSLLHead(city);
    } else if (position == sublist.getSize() + 1) {
        sublist.addToSLLTail(city);
    } else {
        SLLNode<T> newNode = new SLLNode<>(city);
        SLLNode<T> prev = sublist.getHead();
        for (int i = 1; i < position - 1; i++) {
            prev = prev.getNext();
        }
        newNode.setNext(prev.getNext());
        prev.setNext(newNode);
        sublist.incrementSize();
    }

    System.out.println("City added to sublist '" + sublistKey + "' at position " + position);
}

private void displayMenu() {
    System.out.println("Menu:");
    System.out.println("1. Add node to MSLL head");
    System.out.println("2. Add node to MSLL tail");
    System.out.println("3. Delete node from MSLL");
    System.out.println("4. Check if node exists in MSLL");
    System.out.println("5. Make city sublist empty");
    System.out.println("6. Delete city sublist");
    System.out.println("7. Display city sublist");
    System.out.println("8. Add city to sublist at rear");
    System.out.println("9. Add city to sublist at position");
    System.out.println("10. Delete city from sublist");
    System.out.println("11. Calculate distance between two cities");
    System.out.println("12. Search for city");
    System.out.println("13. Exit");
}

}
