public class Motorbike extends Vehicle {
    private double sizeOfCabbie;
    private String typeOfMeter;

    public Motorbike(String plateNo, String model, String make, String capacity, double sizeOfCabbie, String typeOfMeter) {
        super(plateNo, model, make, capacity);
        this.sizeOfCabbie = sizeOfCabbie;
        this.typeOfMeter = typeOfMeter;
    }

    public double getSizeOfCabbie() {
        return sizeOfCabbie;
    }

    public void setSizeOfCabbie(double sizeOfCabbie) {
        this.sizeOfCabbie = sizeOfCabbie;
    }

    public String getTypeOfMeter() {
        return typeOfMeter;
    }

    public void setTypeOfMeter(String typeOfMeter) {
        this.typeOfMeter = typeOfMeter;
    }

    @Override
    public String toString() {
        return "Motorbike{" +
                "sizeOfCabbie=" + sizeOfCabbie +
                ", typeOfMeter='" + typeOfMeter + '\'' +
                ", plateNo='" + super.getPlateNo() + '\'' +
                ", model='" + super.getModel() + '\'' +
                ", make='" + super.getMake() + '\'' +
                ", capacity=" + super.getCapacity() +
                '}';
    }
}
