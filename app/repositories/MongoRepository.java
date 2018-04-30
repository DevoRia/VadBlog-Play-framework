package repositories;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import models.BlogModel;
import org.mongodb.morphia.query.UpdateOperations;

import java.util.ArrayList;

public class MongoRepository extends MongoDatabaseManager{

    @Override
    public ArrayList<DBObject> findAll () {
        DBCursor cursor = getCollection().find();
        ArrayList<DBObject> blog = new ArrayList<>();
        while (cursor.hasNext()){
            blog.add(cursor.next());
        }
        return blog;
    }

    public BlogModel findById(String id) {
        BlogModel blogModel = getMorphia().
                datastore().
                createQuery(BlogModel.class).
                field("_id").
                equal(id).
                get();
        return blogModel;
    }

    @Override
    void save(BlogModel blogModel) {
        getMorphia().datastore().save(blogModel);
    }

    @Override
    void remove(String id) {
        getMorphia().datastore().delete(findById(id));
    }

    @Override
    void edit(BlogModel blogModel, UpdateOperations<BlogModel> operation) {
        getMorphia().datastore().update(blogModel, operation);
    }

    public UpdateOperations<BlogModel> createOperation() {
        return getMorphia().datastore().createUpdateOperations(BlogModel.class);
    }

}
