package people;

public class PersonNumber {
    public String name;
    public Integer number; // может быть null

    public PersonNumber(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return name + ":" + (number != null ? number : "нет номера");
    }
}

