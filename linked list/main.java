import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            MSLL<City> msll = new MSLL<>();
            
            int choice = 0;
            while (choice != 13) {
                System.out.println("Menu:");
                System.out.println("1. addToMSLLHead");
                System.out.println("2. addToMSLLTail");
                System.out.println("3. deleteFromMSLL");
                System.out.println("4. isInMSLList");
                System.out.println("5. makeCitySublistEmpty");
                System.out.println("6. deleteCitySublist");
                System.out.println("7. displayCitySublist");
                System.out.println("8. addCityToSublistAtRear");
                System.out.println("9. addCityToSublistAtPosition");
                System.out.println("10. deleteCityFromSublist");
                System.out.println("11. getDistance");
                System.out.println("12. searchForCity");
                System.out.println("13. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        System.out.print("Enter the key: ");
                        String headKey = scanner.next();
                        msll.addToMSLLHead(headKey);
                        break;
                    case 2:
                        System.out.print("Enter the key: ");
                        String tailKey = scanner.next();
                        msll.addToMSLLTail(tailKey);
                        break;
                    case 3:
                        System.out.print("Enter the key to delete: ");
                        String deleteKey = scanner.next();
                        msll.deleteFromMSLL(deleteKey);
                        break;
                    case 4:
                        System.out.print("Enter the key to search: ");
                        String searchKey = scanner.next();
                        System.out.println(msll.isInMSLL(searchKey));
                        break;
                    case 5:
                        System.out.print("Enter the key of the city sublist to make empty: ");
                        String emptyKey = scanner.next();
                        msll.makeCitySublistEmpty(emptyKey);
                        break;
                    case 6:
                        System.out.print("Enter the key of the city sublist to delete: ");
                        String deleteSublistKey = scanner.next();
                        msll.deleteCitySublist(deleteSublistKey);
                        break;
                    case 7:
                        System.out.print("Enter the key of the city sublist to display: ");
                        String displaySublistKey = scanner.next();
                        msll.displayCitySublist(displaySublistKey);
                        break;
                    case 8:
                        System.out.print("Enter the city name: ");
                        String cityName = scanner.next();
                        System.out.print("Enter the city latitude: ");
                        double latitude = scanner.nextDouble();
                        System.out.print("Enter the city longitude: ");
                        double longitude = scanner.nextDouble();
                        City city = new City(cityName, latitude, longitude);
                        msll.addCityToSublistAtRear(city);
                        break;
                    case 9:
                        System.out.print("Enter the city name: ");
                        String cityNamePos = scanner.next();
                        System.out.print("Enter the city latitude: ");
                        double latitudePos = scanner.nextDouble();
                        System.out.print("Enter the city longitude: ");
                        double longitudePos = scanner.nextDouble();
                        City cityPos = new City(cityNamePos, latitudePos, longitudePos);
                        System.out.print("Enter the position: ");
                        int position = scanner.nextInt();
                        msll.addCityToSublistAtPosition(cityPos, position);
                        break;
                    case 10:
                        System.out.print("Enter the city name to delete: ");
                        String cityToDelete = scanner.next();
                        City cityObj = new City(cityToDelete, 0, 0);
                        msll.deleteCityFromSublist(cityObj);
                        break;
                    case 11:
                        System.out.print("Enter the first city name: ");
                        String city1 = scanner.next();
                        System.out.print("Enter the second city name: ");
                        String city2 = scanner.next();
                        System.out.println("Distance: " + msll.getDistance(city1, city2) + " km");
                        break;
                    case 12:
                        System.out.print("Enter the city name to search: ");
                        String searchCity = scanner.next();
                        System.out.println(msll.searchForCity(searchCity));
                        break;
                    case 13:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
                System.out.println();
            }
        }
    }
}
