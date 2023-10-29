public class Animal {
    private String typeOfAnimal;
    private String name;

    public Animal(String typeOfAnimal, String name) {
        this.typeOfAnimal = typeOfAnimal;
        this.name = name;
    }

    public String getTypeOfAnimal() {
        return typeOfAnimal;
    }

    public void setTypeOfAnimal(String typeOfAnimal) {
        this.typeOfAnimal = typeOfAnimal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "typeOfAnimal='" + typeOfAnimal + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
