import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<Person, List<Animal>> map = new HashMap<>();
        ZooClub zooClub = new ZooClub();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            menu();
            String choose = scanner.next();
            scanner.nextLine();
            switch (choose) {
                case "1": {
                  zooClub.addClubMan();
                    break;
                }
                case "2": {
                    zooClub.addClubAnimal();
                    break;
                }
                case "3": {
                    zooClub.deleteAnimal();
                    break;
                }
                case "4": {
                    zooClub.deleteClubMan();
                    break;
                }
                case "5": {
                   zooClub.deleteExactAnimal();
                    break;
                }
                case "6": {
                    zooClub.showZooClub();
                    break;
                }
                case "7": {
                    map.clear();
                    break;
                }
                case "8": {
                    System.exit(0);
                    break;
                }

            }
        }

    }

    private static void menu() {
        System.out.println("--------------------------------------------");
        System.out.println("Enter 1 to add a Club man");
        System.out.println("Enter 2 to add a animal to Club man");
        System.out.println("Enter 3 to remove a animal to Club man");
        System.out.println("Enter 4 to remove a Club man");
        System.out.println("Enter 5 to remove exact the animal from Club man");
        System.out.println("Enter 6 to show Zoo club");
        System.out.println("Enter 7 clear Zoo club");
        System.out.println("Enter 8 to exit from zoo club");

    }
}