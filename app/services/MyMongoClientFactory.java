package services;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import it.unifi.cerm.playmorphia.MongoClientFactory;
import play.Configuration;

import java.util.Arrays;


public class MyMongoClientFactory  extends MongoClientFactory {
    private Configuration config;
    public MyMongoClientFactory(Configuration config) {
        super(config);
        this.config = config;
    }
    public MongoClient createClient() throws Exception {
        return new MongoClient(Arrays.asList(
                new ServerAddress("locahost", 27017),
                new ServerAddress("locahost", 27018),
                new ServerAddress("locahost", 27019)
        )
        );
    }

    public String getDBName() {
        return config.getString("playmorphia.database");
    }

}