import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;


import java.io.*;
import java.util.*;

public class WestminsterRentalVehicleManager implements RentalVehicleManager {

    static Scanner Sc = new Scanner( System.in );
    private static List<Vehicle> vehicleList = new ArrayList<>();
    private static final int MAX_COUNT = 50;
    private static WestminsterRentalVehicleManager managment = new WestminsterRentalVehicleManager();
    MongoClient mongo = new MongoClient( "localhost", 27017 );


    MongoDatabase database = mongo.getDatabase( "VehicleRentalSystem" );

    MongoCollection<Document> vehicleCollection = database.getCollection( "VehicleCollection" );
    Long dbcount = vehicleCollection.count();
    Document car;
    Document motorBike;


    public void Process() {
        System.out.println( "\n| --------------------------------------|" );
        System.out.println( "| Welcome to WestministerRentalVehicle   |" +
                "\n|\t Select an Option                               |" +
                "\n|\t1)Add a Vehicle                                 |" +
                "\n|\t2)Delete a Vehicle                              |" +
                "\n|\t3)Print the List of Vehicles                    |" +
                "\n|\t4)Rent Vehicles                                 |" +
                "\n|\t5)Save File                                     |" +
                "\n|\t6)Exit Programme                                |" );
        System.out.println( "| -----------------------------------------|" );
        System.out.println( "Please Select A Option : " );
        Integer enterOptionNumber = integerInput();
        do {
            if (enterOptionNumber < 1 || enterOptionNumber > 6) {
                System.out.println( "Invalid input please enter a number within range of 1 and 6" );
                enterOptionNumber = integerInput();
                continue;
            }
        } while (enterOptionNumber < 1 || enterOptionNumber > 6);

        switch (enterOptionNumber) {
            case 1:
                managment.addAVehicle();
                break;
            case 2:
                managment.deleteAVehicle();
                break;
            case 3:
                managment.displayVehicles();
                break;
            case 4:
                managment.RentVehicles();
                break;
            case 5:
                managment.SaveFile();
                break;
            case 6:
                managment.exitProgramme();
                break;

        }
    }

    public void addAVehicle() {
        int count = 0;
        if (count < 50) {

            System.out.println( "Plate No [Please enter a valid Input] :" );
            String plateno = Sc.nextLine();

            while (plateno.isEmpty()) {
                System.out.printf( "That is not a valid Plate Number! Please try again: " );
                plateno = Sc.nextLine();
            }

            System.out.println( "PlateNo :" + plateno );
            System.out.println( "Model [Please enter a valid Plate No ] :" );
            String model = Sc.nextLine();


            while (model.isEmpty()) {
                System.out.printf( "That is not a valid Model! Please try again: " );
                model = Sc.nextLine();
            }
            System.out.println( "Model :" + model );
            System.out.println( "Make [Please enter a valid Model ] :" );
            String make = Sc.nextLine();

            while (make.isEmpty()) {
                System.out.printf( "That is not a valid Make! Please try again: " );
                make = Sc.nextLine();
            }
            System.out.println( "Make :" + make );
            System.out.println( "Capacity [Please enter a valid Make ] :" );
            String capacity = Sc.nextLine();

            while (capacity.isEmpty()) {
                System.out.printf( "That is not a valid Capacity! Please try again: " );
                capacity = Sc.nextLine();
            }

            System.out.println( "Please Select Option [Please enter a valid Capacity] :" );
            System.out.println( "\n01.Add a Car " );
            System.out.println( "02.Add a Motorbike " );

            String VehicleType = Sc.nextLine();
            System.out.println( "VehicleType : " + VehicleType );

            while (VehicleType.isEmpty()) {
                System.out.printf( "That is not a valid Input! Please try again: " );
                VehicleType = Sc.nextLine();
            }

            if (VehicleType.equals( "1" )) {
                System.out.println( "\nNo Of Seats [Please enter a valid No Of Seats ] :" );

                String noofseats = Sc.nextLine();
                System.out.println( "NoofSeats : " + noofseats );

                while (noofseats.equals( "" )) {
                    System.out.printf( "That is not a valid Input! Please try again: " );
                    noofseats = Sc.nextLine();
                }

                System.out.println( "Air Condition [Please enter a valid AirCondition Type] :" );
                String aircondition = Sc.nextLine();
                System.out.println( "Air Condition : " + aircondition );

                while (aircondition.isEmpty()) {
                    System.out.printf( "That is not a valid Input! Please try again: " );
                    aircondition = Sc.nextLine();
                }


                System.out.println( "Car Added Successfully" );

                Car vehicle = new Car( plateno, model, make, capacity, noofseats, aircondition );
                vehicleList.add( vehicle );

                Document Document = new Document( "title","MongoDB" )
                        .append("PLate NO",plateno).append("Model",model).append("Make",make).append("Capacity",capacity).append("NoOfSeats",noofseats).append("AirCondition",aircondition);
                vehicleCollection.insertOne(Document);
                dbcount=dbcount+1;
                System.out.println("used parking space"+dbcount);
                System.out.println("Document Insert Successfully");


                Process();


                count++;

            } else if (VehicleType.equals( "2" )) {
                Scanner Mb = new Scanner( System.in );
                System.out.println( "\nSize Of Cabbie :" );
                int sizeofcabbie = 0;

                do {
                    System.out.print( "Please enter a valid Input: " );
                    while (!Mb.hasNextInt()) {
                        System.out.printf( "\"%s\" is not a valid Size Of Cabbie:\n" );
                        sizeofcabbie = Mb.nextInt();
                    }
                } while (sizeofcabbie < 0);

                System.out.println( "Type Of Meter :" );
                String typeofmeter = Sc.nextLine();

                while (typeofmeter.isEmpty()) {
                    System.out.printf( "That is not a valid Type Of Meter! Please try again: " );
                    typeofmeter = Sc.nextLine();
                }


                System.out.println( "Bike Added Successfully" );

                count++;

                Vehicle vehicle = new Motorbike( plateno, model, make, capacity, sizeofcabbie, typeofmeter );
                vehicleList.add( vehicle );



                Document document = new Document("title","MongoDB")
                        .append("PLate NO",plateno).append("Model",model).append("Make",make).append("Capacity",capacity).append("SizeOfCabbie",sizeofcabbie).append("TypeOfMeter",typeofmeter);
                dbcount=dbcount+1;
                System.out.println("used parking space"+dbcount);
                vehicleCollection.insertOne(document);
                System.out.println("Document Insert Successfully");



                Process();


            } else {
                System.out.println( "Please Enter a Valid Type" );
            }
        } else {
            System.out.println( "No Space Available Here" );
        }
        Process();
    }


    public void deleteAVehicle() {
        System.out.println( "Enter vehicle plate no to be delete : " );
        String no = Sc.nextLine();
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getPlateNo().contains( no )) {
                vehicleList.remove( vehicle );
                BasicDBObject theQuery = new BasicDBObject();
                theQuery.put("PLate NO", no);
                DeleteResult result = vehicleCollection.deleteMany(theQuery);
                dbcount=dbcount-1;
                System.out.println("used parking space"+dbcount);
                System.out.println( "Vehicle was successfully deleted" );
                System.out.println("Remainning Parking Lots"+(50-dbcount));
                Process();
            } else {
                System.out.println( "Vehicle doesn't exist!" );
                Process();
            }
        }
    }

    public void displayVehicles() {

        System.out.println( "-----------------------------------------------------------------------------" );
        MongoCollection<Document> vehicleCollection=database.getCollection( "VehicleCollection" );
        System.out.println( "-----------------------------------------------------------------------------" );
        FindIterable<Document> motorbikeEntry = vehicleCollection.find();

        vehicleList.sort( new ComparatorFroMake() );
        for (Vehicle v: vehicleList) {
            System.out.println(v);
        }

        Iterator<Document> iteratornew = motorbikeEntry.iterator();
        int j = 0;
        while (iteratornew.hasNext()) {
            System.out.println(iteratornew.next());
            j++;
        }
        for (Vehicle CCC : managment.vehicleList) {
            System.out.println( CCC.toString() );
        }
        System.out.println( "-----------------------------------------------------------------------------" );

        Process();


    }



    public void RentVehicles() {
        System.out.println( "Enter The Plate No :" );
        String getplateno = Sc.nextLine();
        for (Vehicle qqq : vehicleList) {
            if (qqq.getPlateNo().contains( getplateno )) {
                BasicDBObject theQuery = new BasicDBObject();
                theQuery.put("PLate NO", qqq);
                vehicleCollection.drop();
                System.out.println( "Rent Vehicle Successfully" );
                Process();
            }  else {
                System.out.println( "Vehicle doesn't exist!" );
                Process();
            }
        }
        Process();
    }

    public void SaveFile() {
        try {

            MongoCursor<Document> cursor = vehicleCollection.find().iterator();
            String path = "F:\\rental.txt";

            PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter( path,true ) ) );
            while (cursor.hasNext()){
                out.println( cursor.next().toJson() );
                System.out.println("File Save Successfully!!!");
            }
            out.flush();
            out.close();

        }catch (IOException e){
            System.out.println("Error to Save To File !!!");
        }

    }


    public static void exitProgramme() {

        System.out.println( "Thank You !!!" );
    }

    private static int integerInput() {
        Scanner input = new Scanner( System.in );
        while (!input.hasNextInt()) {
            System.out.println( "please check for your input,it is not in proper order make sure you enter a number " );
            input.next();

        }
        Integer inputValue = input.nextInt();
        return inputValue;


    }

    class ComparatorFroMake implements Comparator<Vehicle>{

        @Override
        public int compare(Vehicle o1, Vehicle o2) {
            return o1.getMake().compareTo( o2.getMake() );
        }
    }

}
