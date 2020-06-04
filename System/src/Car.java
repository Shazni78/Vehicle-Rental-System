public class Car extends Vehicle {
    private String noOfSeats;
    private String airCondition;

    public Car(String plateNo, String model, String make, String capacity, String noOfSeats, String airCondition) {
        super(plateNo, model, make, capacity);
        this.noOfSeats = noOfSeats;
        this.airCondition = airCondition;
    }

    public String getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(String noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public String isAirCondition() {
        return airCondition;
    }

    public void setAirCondition(String airCondition) {
        this.airCondition = airCondition;
    }

    @Override
    public String toString() {
        return "Car{" +
                "noOfSeats=" + noOfSeats +
                ", airCondition=" + airCondition +
                ", plateNo='" + super.getPlateNo() + '\'' +
                ", model='" + super.getModel() + '\'' +
                ", make='" + super.getMake() + '\'' +
                ", capacity=" + super.getCapacity() +
                '}';
    }

}
