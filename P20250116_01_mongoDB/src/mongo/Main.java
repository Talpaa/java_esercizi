package mongo;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document; 

public class Main {

	public static void main(String[] args) {
		
		String uri = "mongodb+srv://xeyewal413:68Dh9bXsBQPPZani@bd3cluster.857gz.mongodb.net/?retryWrites=true&w=majority&appName=BD3Cluster";

	    try (MongoClient mongoClient = MongoClients.create(uri)) {
	        MongoDatabase database = mongoClient.getDatabase("BD3");
	        MongoCollection<org.bson.Document> collection = database.getCollection("test");
	        Document doc = collection.find().first();
	        if (doc != null) {
	            System.out.println(doc.toJson());
	        } else {
	            System.out.println("No matching documents found.");
	        }

		    //insert(collection);
	        findAll(collection);
	    }catch (Exception e) {
			
	    	System.err.println(e.getMessage());
	    	e.printStackTrace();
		}

	}
	
	private static void insert(MongoCollection<Document> collection) {
		
		Document car = new Document("brand", "fiat").append("model", "Panda");
		
		Document newDoc = new Document("name", "Jack").append("age", 35).append("car", car);
		
		collection.insertOne(newDoc);
	}
	
	private static void findAll(MongoCollection<Document> collection) {
		
		FindIterable<Document> documents = collection.find();
		
		for (Document document : documents) {
			System.out.println(document.toJson());
		}
	}

}
