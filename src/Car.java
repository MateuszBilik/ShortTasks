public class Car {

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
