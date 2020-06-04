import java.util.Date;

public class Shedule {
    private Date pickUpDate;
    private Date dropDate;

    public Shedule(Date pickUpDate, Date dropDate) {
        this.pickUpDate = pickUpDate;
        this.dropDate = dropDate;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Date getDropDate() {
        return dropDate;
    }

    public void setDropDate(Date dropDate) {
        this.dropDate = dropDate;
    }


}
