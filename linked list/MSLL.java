import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MSLL<T>  {
    
private MSLLNode<T> head;
private Scanner scanner;
private Map<String, Coordinate> cityCoordinates; 
Map<String, City> cities = new HashMap<>();
   
public MSLL() {
    this.head = null;
    this.scanner = new Scanner(System.in);
    this.cityCoordinates = new HashMap<>();
    
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
public void displayCitySublist(String key) throws IllegalArgumentException {
    MSLLNode<T> current = findNode(key);
    if (current == null) {
        throw new IllegalArgumentException("Node with key '" + key + "' does not exist.");
    }

    current.getList().displayList();
}



 public void addCityToSublistAtRear(String sublistKey, String city, double latitude, double longitude) throws IllegalArgumentException {
        MSLLNode<T> sublistNode = findNode(sublistKey);
        if (sublistNode == null) {
            throw new IllegalArgumentException("Sublist with key '" + sublistKey + "' does not exist.");
        }
        String cityName = null;
        // Create a new City object with the provided cityName, latitude, and longitude
        City cityObject = new City(city, latitude, longitude);
        // Add the city object to the sublist at the rear
        sublistNode.getList().addToSLLTail((T) cityObject, latitude, longitude);
       
         // Store the city coordinates in the cityCoordinates map
        cityCoordinates.put(city, new Coordinate(latitude, longitude));
    }
    
    
    
    

public void addCityToSublistAtPosition(T city, String sublistKey, int position, double latitude, double longitude) {
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

    if (position == 1) {
        sublist.addToSLLHead(city, latitude, longitude);
    } else if (position == sublist.getSize() + 1) {
        sublist.addToSLLTail(city, latitude, longitude);
    } else {
        SLLNode<T> newNode = new SLLNode<>(city, latitude, longitude);
        SLLNode<T> prev = sublist.getHead();
        for (int i = 1; i < position - 1; i++) {
            prev = prev.getNext();
        }
        newNode.setNext(prev.getNext());
        prev.setNext(newNode);
        sublist.incrementSize();
    }

    // Store the city coordinates in the cityCoordinates map
    cityCoordinates.put((String) city, new Coordinate(latitude, longitude));

    System.out.println("City added to sublist '" + sublistKey + "' at position " + position);
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

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double r = 6372.8; // radius of the Earth in kilometers

        double phi1 = Math.toRadians(lat1);
        double phi2 = Math.toRadians(lat2);
        double deltaPhi = Math.toRadians(lat2 - lat1);
        double deltaLambda = Math.toRadians(lon2 - lon1);

        double a = Math.sin(deltaPhi / 2) * Math.sin(deltaPhi / 2)
                + Math.cos(phi1) * Math.cos(phi2) * Math.sin(deltaLambda / 2) * Math.sin(deltaLambda / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return r * c;
    }

   public double getDistance(String city1, String city2) throws IllegalArgumentException {
        double earthRadius = 6371; // Radius of the Earth in kilometers 
       double latitude1 = getLatitude(city1);
        double longitude1 = getLongitude(city1);
        double latitude2 = getLatitude(city2);
        double longitude2 = getLongitude(city2);

        // Calculate the distance between the two cities using the Haversine formula
            // Calculate the differences between the coordinates
        double dLat = latitude2 - latitude1;
        double dLon = longitude2 - longitude1;

        // Calculate the distance using the Haversine formula
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(latitude1) * Math.cos(latitude2) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = earthRadius * c;
        
        
        distance = calculateDistance(latitude1, longitude1, latitude2, longitude2);
        return distance;
    }
   

void deleteCityFromSublist(String city10) {
    MSLLNode<T> current = head;
    while (current != null) {
        // i did some casting here
        current.getList().deleteFromSLL(city10);
        current = current.getNext();
    }
}
    
    public double getLatitude(String cityName) throws IllegalArgumentException {
        Coordinate coordinate = cityCoordinates.get(cityName);
        if (coordinate != null) {
            return coordinate.getLatitude();
        }
        throw new IllegalArgumentException("City '" + cityName + "' does not exist.");
    }

    public double getLongitude(String cityName) throws IllegalArgumentException {
        Coordinate coordinate = cityCoordinates.get(cityName);
        if (coordinate != null) {
            return coordinate.getLongitude();
        }
        throw new IllegalArgumentException("City '" + cityName + "' does not exist.");
    }


}




