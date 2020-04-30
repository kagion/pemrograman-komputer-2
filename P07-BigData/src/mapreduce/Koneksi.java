/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapreduce;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kagion
 */
public class Koneksi {

    public static MongoDatabase sambungDB() {
        //Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try {
            MongoClient client = (MongoClient) MongoClients.create();
            MongoDatabase database = client.getDatabase("bigdata");
            return database;
        } catch (Exception e) {
            System.out.println("Koneksi Gagal: " + e.getMessage());
        }
        return null;
    }
}
