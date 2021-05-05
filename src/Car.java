import java.util.Objects;

public class Car {

    private String Name;
    private String LastName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(Name, car.Name) && Objects.equals(LastName, car.LastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, LastName);
    }

    public void printTopSpeed(){
        System.out.println("Top speed of the vehicles is 100 kmph");
    }
    public void printTopSpeed(int topSpeed){
        System.out.println("Top speed of the vehicles is " + topSpeed + " kmph");
    }
    public void printTopSpeed(String vehicleName, int topSpeed){
        System.out.println("Top speed of the vehicles " + vehicleName + " is " + topSpeed + " kmph");
    }
}
