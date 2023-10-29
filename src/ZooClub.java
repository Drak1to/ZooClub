import java.util.*;

public final class ZooClub {
    Map<Person, List<Animal>> map = new HashMap<>();



    public ZooClub() {
        map.put(new Person(36, "Max"), new ArrayList<>());
        map.put(new Person(26, "Victor"), new ArrayList<>());

    }

    public Map<Person, List<Animal>> getMap() {
        return map;
    }

    public void setMap(Map<Person, List<Animal>> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "ZooClub{" + "map=" + map + '}';
    }

    public void addClubMan() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write name of Club man ");
        String name = scanner.nextLine();
        System.out.println("Write age of Club man");
        int age = scanner.nextInt();
        Person person = new Person(age, name);
        map.put(person, new ArrayList<>());
        System.out.println("Person" + person.toString() + " has been added");
    }

    public void addClubAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write name of ClubMan");
        String nameOfPerson = scanner.next();
        System.out.println("Write age of ClubMan");
        int ageOfPerson = scanner.nextInt();
        scanner.nextLine();

        if (isCLubManExist(nameOfPerson, ageOfPerson, map)) {
            System.out.println("Write type of Club animal ");
            String type = scanner.nextLine();
            System.out.println("Write name of Club animal");
            String name = scanner.next();

            Animal animal = new Animal(type, name);

            Iterator<Map.Entry<Person, List<Animal>>> iterator = map.entrySet().iterator();

            while (iterator.hasNext()) {
                Map.Entry<Person, List<Animal>> mapNext = iterator.next();
                if (mapNext.getKey().getName().equalsIgnoreCase(nameOfPerson) && mapNext.getKey().getAge() == ageOfPerson) {
                    List<Animal> animals = mapNext.getValue();

                    animals.add(animal);
                    System.out.println("This animal " + animals + " has been added");
                }

            }

        } else {
            System.out.println("This person didnt exist");
        }
    }

    public void deleteClubMan() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write name");
        String name = scanner.next();
        System.out.println("Write age");
        int age = scanner.nextInt();
        scanner.nextLine();

        if (isCLubManExist(name, age, map)) {
            Iterator<Map.Entry<Person, List<Animal>>> iterator = map.entrySet().iterator();

            while (iterator.hasNext()) {
                Map.Entry<Person, List<Animal>> mapNext = iterator.next();

                if (mapNext.getKey().getName().equalsIgnoreCase(name) && mapNext.getKey().getAge() == age) {
                    iterator.remove();
                    System.out.println("Person " + name + " has been deleted");
                }
            }
        } else {
            System.out.println("This person didnt exist");
        }


    }

    public void deleteAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write name");
        String name = scanner.next();
        System.out.println("Write age");
        int age = scanner.nextInt();
        scanner.nextLine();

        if (isCLubManExist(name, age, map)) {

            System.out.println("Write type of Club animal ");
            String type = scanner.nextLine();
            System.out.println("Write name of Club animal");
            String nameOfAnimal = scanner.next();
            if (isCLubAnimalExist(name, age, map, nameOfAnimal, type)) {

                Iterator<Map.Entry<Person, List<Animal>>> entryIterator = map.entrySet().iterator();

                while (entryIterator.hasNext()) {
                    Map.Entry<Person, List<Animal>> mapNext = entryIterator.next();

                    if (mapNext.getKey().getName().equalsIgnoreCase(name) && mapNext.getKey().getAge() == age) {
                        List<Animal> animals = mapNext.getValue();

                        Iterator<Animal> animalIterator = animals.iterator();

                        while (animalIterator.hasNext()) {
                            Animal nextAnimal = animalIterator.next();
                            if (nextAnimal.getName().equalsIgnoreCase(nameOfAnimal) && nextAnimal.getTypeOfAnimal().equalsIgnoreCase(type)) {
                                animalIterator.remove();
                            }
                        }

                    }
                }
            } else {
                System.out.println("This animal didint exist");
            }
        } else {
            System.out.println("This person didnt exist");
        }
    }

    public void showZooClub() {

        for (Map.Entry<Person, List<Animal>> entry : map.entrySet()) {
            Person key = entry.getKey();
            List<Animal> value = entry.getValue();

            System.out.println(key + " ---> " + value);

        }

    }

    public void deleteExactAnimal() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write type of Club animal ");
        String type = scanner.nextLine();


        Iterator<Map.Entry<Person, List<Animal>>> entryIterator = map.entrySet().iterator();

        while (entryIterator.hasNext()) {
            Map.Entry<Person, List<Animal>> mapNext = entryIterator.next();


            List<Animal> animals = mapNext.getValue();

            Iterator<Animal> animalIterator = animals.iterator();

            while (animalIterator.hasNext()) {
                Animal nextAnimal = animalIterator.next();
                if (nextAnimal.getTypeOfAnimal().equalsIgnoreCase(type)) {
                    animalIterator.remove();
                }
            }

        }
    }


    public boolean isCLubManExist(String name, int age, Map<Person, List<Animal>> map) {
        for (Map.Entry<Person, List<Animal>> entry : map.entrySet()) {
            if (entry.getKey().getName().equalsIgnoreCase(name) && entry.getKey().getAge() == age) {
                return true;

            }
        }
        return false;
    }

    public boolean isCLubAnimalExist(String name, int age, Map<Person, List<Animal>> map, String nameOfAnimal, String typeOfAnimal) {
        if (isCLubManExist(name, age, map)) {
            Iterator<Map.Entry<Person, List<Animal>>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Person, List<Animal>> mapNext = iterator.next();

                if (mapNext.getKey().getName().equalsIgnoreCase(name) && mapNext.getKey().getAge() == age) {
                    List<Animal> animals = mapNext.getValue();

                    Iterator<Animal> animalIterator = animals.iterator();

                    while (animalIterator.hasNext()) {
                        Animal nextAnimal = animalIterator.next();
                        if (nextAnimal.getName().equalsIgnoreCase(nameOfAnimal) && nextAnimal.getTypeOfAnimal().equalsIgnoreCase(typeOfAnimal)) {
                            return true;
                        }
                    }

                }
            }
        }
        return false;
    }


}