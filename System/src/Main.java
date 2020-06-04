import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.MongoCredential;
import org.bson.Document;


public class Main {
    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("localhost",27017);
        MongoCredential mongoCredential = MongoCredential.createCredential("Shazni", "VehicleRentalSystem","shazni1234".toCharArray());
        MongoDatabase mongoDatabase = mongoClient.getDatabase("VehicleRentalSystem");
        MongoCollection <Document> DatabaseCollection = mongoDatabase.getCollection("vehicle");

        WestminsterRentalVehicleManager westminsterRentalVehicleManager = new WestminsterRentalVehicleManager();
        westminsterRentalVehicleManager.Process();

    }

}
