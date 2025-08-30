public class Passenger {
    static int id=1;
    String name;
    String berthPreference;
    int age;
    int passengerId;
    String allotted;
    int number;
    public Passenger(String name, String berthPreference, int age) {
        this.name = name;
        this.berthPreference = berthPreference;
        this.age = age;
        this.passengerId = id++;
        this.allotted = "";
        this.number = -1;
    }
}