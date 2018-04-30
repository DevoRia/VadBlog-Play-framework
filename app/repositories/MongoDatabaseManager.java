package repositories;

import com.mongodb.DBCollection;
import it.unifi.cerm.playmorphia.PlayMorphia;
import models.BlogModel;
import org.mongodb.morphia.query.UpdateOperations;

import javax.inject.Inject;
import java.util.ArrayList;

public abstract class MongoDatabaseManager {

    @Inject
    private PlayMorphia morphia;

    public PlayMorphia getMorphia() {
        return morphia;
    }

    DBCollection getCollection() {
        return morphia.datastore().getCollection(BlogModel.class);
    }

    abstract ArrayList findAll();
    abstract void save (BlogModel blogModel);
    abstract void remove (String id);
    abstract void edit(BlogModel blogModel, UpdateOperations<BlogModel> operation);
}
