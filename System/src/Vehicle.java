public class  Vehicle {
    private String plateNo;
    private String model;
    private String make;
    private String capacity;


    public Vehicle(String plateNo, String model, String make, String capacity) {
        this.plateNo = plateNo;
        this.model = model;
        this.make = make;
        this.capacity = capacity;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String isCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }


    public String getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "plateNo='" + plateNo + '\'' +
                ", model='" + model + '\'' +
                ", make='" + make + '\'' +
                ", capacity=" + capacity +
                '}';
    }


}
